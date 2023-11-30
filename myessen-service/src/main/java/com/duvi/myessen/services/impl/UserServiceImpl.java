package com.duvi.myessen.services.impl;

import com.duvi.myessen.controller.exception.user.UserExistsException;
import com.duvi.myessen.controller.exception.user.UserNotFoundException;
import com.duvi.myessen.domain.users.RegisterDTO;
import com.duvi.myessen.domain.users.User;
import com.duvi.myessen.repository.UserRepository;
import com.duvi.myessen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails findByUsername(String username) throws UserNotFoundException {
        if (!userRepository.existsByUsername(username)) {
            throw new UserNotFoundException(username);
        }
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails findByEmail(String email) throws UserNotFoundException {
        if (!userRepository.existsByEmail(email)) {
            throw new UserNotFoundException(email);
        }
        return userRepository.findByUsername(email);
    }

    @Override
    public UserDetails findByLogin(String login) throws UserNotFoundException {
        if (userRepository.existsByUsername(login)) {
            return userRepository.findByUsername(login);
        } else if (userRepository.existsByEmail(login)) {
            return userRepository.findByEmail(login);
        } else {
            throw new UserNotFoundException(login);
        }

    }

    @Override
    public void createUser(User user) throws UserExistsException {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserExistsException(user.getUsername());
        } else if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserExistsException(user.getEmail());
        }
        userRepository.save(user);
    }

    @Override
    public void createUser(RegisterDTO userDTO) throws UserExistsException {
        User user = new User(userDTO);
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UserExistsException(user.getUsername());
        } else if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserExistsException(user.getEmail());
        }
        userRepository.save(user);
    }

    @Override
    public void updateUser(String username, User newUser) {
        Optional<User> optionalUser = userRepository.findById(username);
        if (optionalUser.isPresent()) {
            User oldUser = optionalUser.get();
            oldUser.updateWithUser(newUser);
            userRepository.save(oldUser);
        } else {
            userRepository.save(newUser);
        }
    }

    @Override
    public void deleteUser(String login) throws UserNotFoundException {
        User user = (User) this.findByLogin(login);
        if (user == null) {
            throw new UserNotFoundException(login);
        }
        userRepository.delete(user);
    }
}
