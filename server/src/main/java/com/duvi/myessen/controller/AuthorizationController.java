package com.duvi.myessen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.domain.users.AuthorizationDTO;
import com.duvi.myessen.domain.users.LoginResponseDTO;
import com.duvi.myessen.domain.users.RegisterDTO;
import com.duvi.myessen.domain.users.User;
import com.duvi.myessen.repository.UserRepository;
import com.duvi.myessen.services.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthorizationController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    @GetMapping("/login")
    public ResponseEntity<LoginResponseDTO> currentUser(@RequestHeader HttpHeaders headers) {

        User user = new User();
        return new ResponseEntity<>(new LoginResponseDTO("2", user), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthorizationDTO data) {
        
        UserDetails user = this.repository.findByEmail(data.login());
        if (user == null) {
           user = this.repository.findByUsername(data.login());
        };
        User foundUser = (User) user;
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        
        return new ResponseEntity<>(new LoginResponseDTO(token, foundUser), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid RegisterDTO data) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptedPassword, data.role());
        this.repository.save(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    

}
