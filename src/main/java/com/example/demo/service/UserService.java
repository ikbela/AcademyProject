package com.example.demo.service;



import com.example.demo.model.User;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
@Autowired
    private UserRepository userRepo;
@Autowired
    private RoleRepository roleRepo;
@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User create(User user)
    {
        return userRepo.save(user);
    }
    public void saveWithUserRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_USER"));
        userRepo.save(user);
    }

    // 2
    public void saveUserWithAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        userRepo.save(user);
    }
    public void saveDoctor(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_DOCTOR"));
        userRepo.save(user);
    }
    public void saveUserWithSuperAdminRole(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleRepo.findByName("ROLE_SUPER_ADMIN"));
        userRepo.save(user);
    }
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // 3
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    public List<User> allUsers() { return userRepo.findAll(); }
    public User upgradeUser(User user) {
        user.setRoles(roleRepo.findByName("ROLE_ADMIN"));
        return userRepo.save(user);
    }
    public void deleteUser(User user) {
        userRepo.delete(user);
    }
//    public List<User> findBySpecificRoles(Long r) {
//        return userRepo.findAllByRoles(roleRepo.findById(r).orElse(null)); }


}