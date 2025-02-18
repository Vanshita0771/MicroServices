package com.lcwd.user.service.User.Service.services;


import com.lcwd.user.service.User.Service.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getUsers();
    User getUserById(String userId);
    User updateUser(User user);
    void deleteUser(String userId);
}
