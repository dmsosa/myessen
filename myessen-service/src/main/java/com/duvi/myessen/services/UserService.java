package com.duvi.myessen.services;

import com.duvi.myessen.controller.exception.user.UserExistsException;
import com.duvi.myessen.controller.exception.user.UserNotFoundException;
import com.duvi.myessen.domain.users.RegisterDTO;
import com.duvi.myessen.domain.users.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> findAll();
    UserDetails findByUsername(String username) throws UserNotFoundException;
    UserDetails findByEmail(String email) throws UserNotFoundException;
    UserDetails findByLogin(String login) throws UserNotFoundException;
    void createUser(User user) throws UserExistsException;
    void createUser(RegisterDTO userDTO) throws UserExistsException;
    void updateUser(String username, User newUser);
    void deleteUser(String login) throws UserNotFoundException;

}