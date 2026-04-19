package com.UserManagmentSystems.UserManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class UserManagementSystemApplication {

	public static void main(String[] args) {

		// Check if running on Railway (or any cloud env)
		String runningOnRailway = System.getenv("RAILWAY_ENVIRONMENT");

		if (runningOnRailway == null) {
			// Local environment → use dotenv
			Dotenv dotenv = Dotenv.load();

			System.setProperty("DB_URL", dotenv.get("DB_URL"));
			System.setProperty("USER_NAME", dotenv.get("USER_NAME"));
			System.setProperty("PASSWORD", dotenv.get("PASSWORD"));
		}

		SpringApplication.run(UserManagementSystemApplication.class, args);
	}
}
