package com.tweteroo.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.model._User;

public interface UserRepository extends JpaRepository<_User, Long> {
    
    Optional<_User> findByUsername(String username);

}
