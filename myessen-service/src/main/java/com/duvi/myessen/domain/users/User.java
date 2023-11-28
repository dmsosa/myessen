package com.duvi.myessen.domain.users;

import java.util.Collection;
import java.util.List;


import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Table(name = "users")
@Entity(name = "users")
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String username;
    private String bio;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User(String username, String email, String password, UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.bio = null;
    }

    public User(RegisterDTO userDTO) {
        this.username = userDTO.username();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.role = userDTO.role();
    }
    public void updateWithUser(User newUser) {
        this.username = newUser.getUsername();
        this.email = newUser.getEmail();
        this.password = newUser.getPassword();
        this.role = newUser.getRole();
        this.bio = newUser.getBio();
    }
    @Override
    public String getUsername() {
        return username;
    } 

    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    return true;  
  }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
