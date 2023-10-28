package com.duvi.myessen.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.duvi.myessen.domain.users.User;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) throws JWTCreationException {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
            .withIssuer("myessen")
            .withSubject(user.getUsername())
            .withClaim("email", user.getEmail())
            .withIssuedAt(LocalDateTime.now().toInstant(ZoneOffset.of("+00:00")))
            .withExpiresAt(generateExpirationDate())
            .sign(algorithm);
            return token;

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Fehler bei der Erstellungen des Tokens", exception);
        }
    }

    public String validateToken(String token) {
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
            .withIssuer("myessen")
            .build();

            decodedJWT = verifier.verify(token);
            return decodedJWT.getSubject();

        } catch (JWTVerificationException exception) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("+00:00"));
    }
}
