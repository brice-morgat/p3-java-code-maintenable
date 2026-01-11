package com.openclassroom.chatop.services;


import com.openclassroom.chatop.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword()) // hash BCrypt en DB
                .authorities(List.of())
                .build();
    }
}
