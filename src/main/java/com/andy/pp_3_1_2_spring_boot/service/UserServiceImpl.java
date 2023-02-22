package com.andy.pp_3_1_2_spring_boot.service;

import com.andy.pp_3_1_2_spring_boot.dao.UserDAO;
import com.andy.pp_3_1_2_spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    @Autowired
    public UserServiceImpl(UserDAO userDAO) {this.userDAO = userDAO;}

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    public User getUserByID(Long id) {
        return userDAO.getReferenceById(id);
    }
    @Transactional
    @Override
    public void deleteUserByID(Long id) {
        userDAO.deleteById(id);
    }
}
