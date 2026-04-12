package com.UserManagmentSystems.UserManagementSystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_data")
public class User {
    @Id
    private int id;
    @Column(name="First_Name")
    private String firstname;
    @Column(name="last_Name")
    private String lastname;
    @Column(name="Email")
    private String email;
    @Column(name="Password")
    private String password;
    @Column(name="Age")
    private int age;
    @Column(name="Profession")
    private String profession;
    @Column(name="Role")
    private String role;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
                + ", password=" + password + ", age=" + age + ", profession=" + profession + ", role=" + role + "]";
    }

    


}
