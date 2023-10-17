package com.duvi.myessen.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duvi.myessen.adapters.UserRepository;
import com.duvi.myessen.domain.transfer.LoginResponseDTO;
import com.duvi.myessen.domain.transfer.UserDTO;



@RestController
@RequestMapping("/api/user")
public class UserController {

    UserRepository repository;

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public ResponseEntity<LoginResponseDTO> currentUser(@RequestHeader Map<String, String> headers) {
        String username = headers.get("username");
        String token = headers.get("authorization");
        token = token.replace("Bearer ", "");
        UserDTO user = this.repository.findUserByUsername(username).toUserDTO();
        logger.debug("hello");
        return ResponseEntity.ok(new LoginResponseDTO(token, user));
    }
}
