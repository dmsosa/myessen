package com.duvi.myessen.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.adapters.UserRepository;
import com.duvi.myessen.domain.transfer.LoginResponseDTO;
import com.duvi.myessen.domain.transfer.UserDTO;


@RestController
@RequestMapping("api/user")
public class UserController {

    UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<LoginResponseDTO> currentUser(@RequestHeader Map<String, String> headers) {
        String username = headers.get("username");
        String token = headers.get("Authentication");
        token = token.replace("Bearer ", "");
        UserDTO user = this.repository.findUserByUsername(username).toUserDTO();
        return ResponseEntity.ok(new LoginResponseDTO(token, user));
    }
}
