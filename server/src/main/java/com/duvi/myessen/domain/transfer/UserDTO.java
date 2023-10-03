package com.duvi.myessen.domain.transfer;

import com.duvi.myessen.domain.User;


public record UserDTO (Long id, String username, String email, byte[] img) {
    public UserDTO(User user) {
        this(user.getId(), user.getUsername(), user.getEmail(), user.getImg());
    }
}