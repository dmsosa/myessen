package com.duvi.myessen.domain.transfer;

import com.duvi.myessen.domain.users.roles.UserRole;

public record RegisterDTO(String username, String email, String password, UserRole role) {
}
