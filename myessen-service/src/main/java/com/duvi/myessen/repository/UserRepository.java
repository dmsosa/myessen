package com.duvi.myessen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import com.duvi.myessen.domain.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    UserDetails findByUsername(String username);
    UserDetails findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
