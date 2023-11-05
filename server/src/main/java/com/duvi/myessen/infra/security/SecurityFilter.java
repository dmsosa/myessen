package com.duvi.myessen.infra.security;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.duvi.myessen.repository.UserRepository;
import com.duvi.myessen.services.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                var token = this.recoverToken(request);
                if (token != null) {
                    if (!isTokenExpired(token)) {
                        String username = tokenService.validateToken(token);
                        logger.info(String.format("Token received from user with username: \"%s\"", username));
                        UserDetails user = repository.findByUsername(username);
                        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
                filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    private boolean isTokenExpired(String token) {
        Instant expirationDate = tokenService.getExpirationDate(token);
        Instant currentDate = LocalDateTime.now().toInstant(ZoneOffset.of("+00:00"));
        if (expirationDate.compareTo(currentDate) < 0)  {
                return true;
            }
        return false;
    }
}
