package com.alapingping.shouxin.service;

import com.alapingping.shouxin.entity.User;

public interface UserService {
    User getUserByUsername(String username);
    String addUser(User user);
    String login(String username, String password);
    String register(User user);
}
