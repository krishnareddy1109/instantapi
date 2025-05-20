package com.application.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.entity.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}