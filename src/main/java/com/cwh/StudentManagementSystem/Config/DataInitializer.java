package com.cwh.StudentManagementSystem.Config;

import com.cwh.StudentManagementSystem.Entity.Users;
import com.cwh.StudentManagementSystem.Repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner loadSampleData(UsersRepository usersRepository,
                                     PasswordEncoder passwordEncoder) {

        return args -> {
            if (!usersRepository.existsByUsername("Admin")) {
                Users user = new Users();
                user.setUsername("Admin");
                user.setPassword(passwordEncoder.encode("admin@123"));
                user.setActive(true);

                usersRepository.save(user); // ✅ SAVED IN DB
                System.out.println("Admin user created");
            } else {
                System.out.println("Admin already exists");
            }
        };
    }
}
