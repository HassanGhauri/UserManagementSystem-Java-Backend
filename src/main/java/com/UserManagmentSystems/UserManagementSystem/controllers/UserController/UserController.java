package com.UserManagmentSystems.UserManagementSystem.controllers.UserController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.UserManagmentSystems.UserManagementSystem.models.User;
import com.UserManagmentSystems.UserManagementSystem.repositories.UserRep.UserRepo;
import com.UserManagmentSystems.UserManagementSystem.utils.JwtUtil;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class UserController {

    @Autowired
    UserRepo repo;
    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = repo.findAll();
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

    // LOGIN API
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User loginUser) {

        List<User> users = repo.findAll();

        for (User user : users) {

            if (user.getEmail().equals(loginUser.getEmail())
                    && user.getPassword().equals(loginUser.getPassword())) {

                Map<String, Object> response = new HashMap<>();
                String token = jwtUtil.generateToken(user);
                response.put("success", true);
                response.put("message", "Login Successful");
                response.put("token", token);
                response.put("user", user);

                return ResponseEntity.ok(response);
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", "Invalid Email or Password");
        response.put("status", 401);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable int id, @RequestBody User updatedUser) {

        Map<String, Object> response = new HashMap<>();

        return repo.findById(id).map(user -> {

            user.setFirstname(updatedUser.getFirstname());
            user.setLastname(updatedUser.getLastname());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setAge(updatedUser.getAge());
            user.setProfession(updatedUser.getProfession());
            user.setRole(updatedUser.getRole());

            repo.save(user);

            response.put("success", true);
            response.put("message", "User updated successfully");
            response.put("status", 200);
            response.put("user", user);

            return ResponseEntity.ok(response);

        }).orElseGet(() -> {

            response.put("success", false);
            response.put("message", "User not found");
            response.put("status", 404);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        });
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable int id) {

        Map<String, Object> response = new HashMap<>();

        return repo.findById(id).map(user -> {

            repo.delete(user);

            response.put("success", true);
            response.put("message", "User deleted successfully");
            response.put("status", 200);

            return ResponseEntity.ok(response);

        }).orElseGet(() -> {

            response.put("success", false);
            response.put("message", "User not found");
            response.put("status", 404);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        });
    }

}
