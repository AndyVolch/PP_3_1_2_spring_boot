package com.andy.pp_3_1_2_spring_boot.service;

import com.andy.pp_3_1_2_spring_boot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserByID(Long id);

    void deleteUserByID(Long id);
}
