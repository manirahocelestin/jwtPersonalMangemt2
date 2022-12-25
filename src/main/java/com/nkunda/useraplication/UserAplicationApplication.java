package com.nkunda.useraplication;

import com.nkunda.useraplication.domain.Role;
import com.nkunda.useraplication.domain.TitleType;
import com.nkunda.useraplication.domain.User;
import com.nkunda.useraplication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserAplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAplicationApplication.class, args);

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {
            userService.saveRole(new Role(null,"ROLE_USER"));
            userService.saveRole(new Role(null,"ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null,"celestin","maniraho", TitleType.DRIVER, "kigali","078315684","celestino@gmail.com","celestin",null,new ArrayList<>()));
            userService.saveUser(new User(null,"Eric","muhate",TitleType.BUSINESSMAN,"Utah","078954432","muhate@gmail.com","rwanda",null,new ArrayList<>()));
            userService.saveUser(new User(null,"Bosco","rwema",TitleType.TOURISM,"Taxas","8012354687","basco@gmail.com","rwema",null,new ArrayList<>()));
            userService.saveUser(new User(null,"Yvan","burabyo",TitleType.OTHER,"Rwanda","0788301564","burabyo@gmail.com","burabyo",null,new ArrayList<>()));
            userService.saveUser(new User(null,"john","rwema",TitleType.BUSINESSMAN,"NewYork","078564213","john@gmail.com","john",null,new ArrayList<>()));

            userService.addRoleToUser("celestino@gmail.com","ROLE_USER");
            userService.addRoleToUser("celestino@gmail.com","ROLE_MANAGER");
            userService.addRoleToUser("celestino@gmail.com","ROLE_ADMIN");
            userService.addRoleToUser("muhate@gmail.com","ROLE_USER");
            userService.addRoleToUser("muhate@gmail.com","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("basco@gmail.com","ROLE_ADMIN");
            userService.addRoleToUser("basco@gmail.com","ROLE_MANAGER");
            userService.addRoleToUser("burabyo@gmail.com","ROLE_USER");
            userService.addRoleToUser("john@gmail.com","ROLE_USER");
            userService.addRoleToUser("john@gmail.com","ROLE_ADMIN");


        };

    }


}
