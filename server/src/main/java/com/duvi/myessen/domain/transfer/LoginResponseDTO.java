package com.duvi.myessen.domain.transfer;

import org.springframework.security.core.userdetails.UserDetails;

import com.duvi.myessen.domain.users.User;

public record LoginResponseDTO(String token, UserDetails user) {
}
