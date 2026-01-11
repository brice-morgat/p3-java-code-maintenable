package com.openclassroom.chatop.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface IUserService extends UserDetailsService {
    /**
     * Add a User
     * @param user
     * @return Saved User
     */
    public User saveUser(User user);

    /**
     * Get a user by email, or return {@link Optional#empty()} if no user is found.
     *
     * @param email The email of the user to be retrieved.
     * @return Optional<User>
     */
    public Optional<User> getUserByEmail(String email);

    /**
     * This function returns a User object with the given id.
     *
     * @param id The id of the user to be retrieved.
     * @return A User object
     */
    public User getUserById(Long id);

}
