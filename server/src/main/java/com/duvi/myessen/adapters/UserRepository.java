package com.duvi.myessen.adapters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.duvi.myessen.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByUsername(String name);
}
