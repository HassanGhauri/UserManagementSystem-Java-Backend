package com.UserManagmentSystems.UserManagementSystem.controllers.UserController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.UserManagmentSystems.UserManagementSystem.models.User;
import com.UserManagmentSystems.UserManagementSystem.repositories.UserRep.UserRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController

public class UserController {

    @Autowired
    UserRepo repo;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> users=repo.findAll();
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        User user = repo.findById(id).get(); 
        return user;
    }
    

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
       repo.save(user);
    }


    
}
