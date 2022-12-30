//package com.example.chatapp;
//import com.example.chatapp.model.entity.User;
//import com.example.chatapp.model.repo.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DataInitializer {
//
//    @Autowired
//    private UserRepo userRepo;
//    @Bean
//    public CommandLineRunner getCommandLineRunner(){
//        return args->{
//
//            User admin = new User();
//            admin.setUsername("Oliver");
//            admin.setName("Oliver");
//            admin.setRole(User.Role.GeneralUser);
//            admin.setChat1(false);
//            admin.setChat2(false);
////            admin.setPassword("admin");
//            userRepo.save(admin);
//
//            User John = new User();
//            John.setUsername("Will");
//            John.setName("William Alexander");
//            John.setRole(User.Role.GeneralUser);
//            John.setChat1(false);
//            John.setChat2(false);
////            admin.setPassword("admin");
//            userRepo.save(John);
//
//            User Christina = new User();
//            Christina.setUsername("Elizabeth");
//            Christina.setName("Elizabeth Watson");
//            Christina.setRole(User.Role.GeneralUser);
//            Christina.setChat1(false);
//            Christina.setChat2(false);
////            admin.setPassword("admin");
//            userRepo.save(Christina);
//        };
//    }
//}
