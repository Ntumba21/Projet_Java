package com.example.projetjava.services;

import com.example.projetjava.dto.UserRequest;
import com.example.projetjava.entities.UserEntity;
import com.example.projetjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(UserRequest userRequest, String role) {
        UserEntity user = new UserEntity();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setRole(role);
        return userRepository.save(user);
    }
}
