package com.andy.pp_3_1_2_spring_boot.controller;

import com.andy.pp_3_1_2_spring_boot.model.User;
import com.andy.pp_3_1_2_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public String getAllUsers(Model model){
        List<User> listOfUsers = userService.getAllUsers();
        model.addAttribute("allUsers", listOfUsers);
        return "users";
    }
    @RequestMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user_form";
    }
    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user){
        userService.saveUser(user);
        return "redirect:/";
    }
    @RequestMapping("/updateUser")
    public String updateUser(@RequestParam("UserID") Long id, Model model){
        User user = userService.getUserByID(id);
        model.addAttribute("user", user);
        return "user_form";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("UserID") Long id){
        userService.deleteUserByID(id);
        return "redirect:/";
    }
}
