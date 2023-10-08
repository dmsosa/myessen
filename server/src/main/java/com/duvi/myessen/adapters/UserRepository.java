package com.duvi.myessen.adapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import com.duvi.myessen.domain.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    boolean existsByUsername(String name);
    UserDetails findUserByEmail(String email);
}
