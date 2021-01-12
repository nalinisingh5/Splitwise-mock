package com.splitwise.service;

import com.splitwise.model.User;
import com.splitwise.repository.UserRepository;

public class UserService {
    public User createUser(String userId, String name, String email, String phoneNumber) {
        User user = new User(userId, name, email, phoneNumber);
        UserRepository.userHashMap.putIfAbsent(email, user);
        return user;
    }
}
