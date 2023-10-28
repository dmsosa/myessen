package com.duvi.myessen.domain.users;

public record RegisterDTO(String username, String email, String password, UserRole role) {
}
