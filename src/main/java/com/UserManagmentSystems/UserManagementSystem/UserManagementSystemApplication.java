package com.UserManagmentSystems.UserManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class UserManagementSystemApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

System.out.println("DB URL: " + dotenv.get("DB_URL"));
System.out.println("USER: " + dotenv.get("USER_NAME"));
System.out.println("PASS: " + dotenv.get("PASSWORD"));

System.setProperty("DATABASE_URL", dotenv.get("DB_URL"));
System.setProperty("USERNAME", dotenv.get("USER_NAME"));
System.setProperty("PASSWORD", dotenv.get("PASSWORD"));

		SpringApplication.run(UserManagementSystemApplication.class, args);
	}

}
