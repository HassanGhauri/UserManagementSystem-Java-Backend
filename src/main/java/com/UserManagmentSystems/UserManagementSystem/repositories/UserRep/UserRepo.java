package com.UserManagmentSystems.UserManagementSystem.repositories.UserRep;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UserManagmentSystems.UserManagementSystem.models.User;

public interface UserRepo extends JpaRepository<User,Integer> {   
}