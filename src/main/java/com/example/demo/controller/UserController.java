package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration/user")
    public String register(@Valid @ModelAttribute("user") User user){
        return "register";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping({"/"})
    public String home(Principal principal, HttpSession session, Model model) {

        String email= principal.getName();
        User user= userService.findByEmail(email);

        userService.create(user);

        if(user.getRoles().get(0).getName().contains("ROLE_ADMIN") || user.getRoles().get(0).getName().contains("ROLE_SUPER_ADMIN")) {
            model.addAttribute("currentUser", user);
            return "redirect:/admin";

        }

        session.setAttribute("userID", user.getId());
        model.addAttribute("currentUser", user);
        return "homeUser";
    }
    @PostMapping("/registration/user")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "register";
        }
        if(userService.allUsers().size()==0) {
            userService.saveUserWithSuperAdminRole(user); }
        else {
            userService.saveWithUserRole(user);
        }
        return "redirect:/login";
    }

    // NEW
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByEmail(username));
        model.addAttribute("users", userService.allUsers());
        return "adminPage";
    }
    @RequestMapping("/admin/{id}")
    public String makeAdmin(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        userService.upgradeUser(user);
        model.addAttribute("users", userService.allUsers());
        return "redirect:/admin";
    }
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, HttpSession session, Model model) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        model.addAttribute("users", userService.allUsers());
        return "redirect:/admin";
    }
}
