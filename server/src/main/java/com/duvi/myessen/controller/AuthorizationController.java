package com.duvi.myessen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.adapters.UserRepository;
import com.duvi.myessen.domain.transfer.AuthorizationDTO;
import com.duvi.myessen.domain.transfer.LoginResponseDTO;
import com.duvi.myessen.domain.transfer.RegisterDTO;
import com.duvi.myessen.domain.transfer.UserDTO;
import com.duvi.myessen.domain.users.User;
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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthorizationDTO data) {
        if (data.email() == null || data.password() == null) {
            return ResponseEntity.badRequest().body("FEHLER\n NICHT ALLES NOTIGES INFORMATION");
        }
        UserDetails user = this.repository.findUserByEmail(data.email());
        if (user == null) {
            return ResponseEntity.badRequest().body("KEIN BENUTZER\n BITTE REGISTIEREN SIE");
        }
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((User) auth.getPrincipal());
        
        return ResponseEntity.ok(new LoginResponseDTO(token, user));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (data.password() == null || data.email() == null || data.username() == null || data.role() == null) {
            return ResponseEntity.badRequest().body("FEHLER\nNICHT ALLES NOTIGES INFORMATION");
        }
        if (this.repository.findUserByEmail(data.email()) != null) {
            return ResponseEntity.badRequest().body("FEHLER\nES GIBT SCHON SOLCHE BENUTZER");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptedPassword, data.role());
        this.repository.save(newUser);
        return ResponseEntity.ok().body("GENAU\nBENUTZER ERSTELLEN");
    }
}
