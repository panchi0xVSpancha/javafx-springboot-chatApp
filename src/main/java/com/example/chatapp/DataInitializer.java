package com.example.chatapp;

import com.example.chatapp.model.entity.User;
import com.example.chatapp.model.entity.Category;
import com.example.chatapp.model.repo.UserRepo;
import com.example.chatapp.model.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo repo;
    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return args->{
            repo.save(new Category("Foods"));
            repo.save(new Category("Drinks"));
            repo.save(new Category("Accessories"));

            User admin = new User();
            admin.setLoginId("aa");
            admin.setName("Ann");
            admin.setRole(User.Role.Admin);
//            admin.setPassword("admin");
            userRepo.save(admin);

            User John = new User();
            John.setLoginId("john");
            John.setName("John");
            John.setRole(User.Role.GeneralUser);
//            admin.setPassword("admin");
            userRepo.save(John);

            User Christina = new User();
            Christina.setLoginId("Christina");
            Christina.setName("Christina");
            Christina.setRole(User.Role.GeneralUser);
//            admin.setPassword("admin");
            userRepo.save(Christina);
        };
    }
}
