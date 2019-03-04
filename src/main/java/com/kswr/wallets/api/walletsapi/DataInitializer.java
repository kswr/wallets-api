//package com.kswr.wallets.api.walletsapi;
//
//import com.kswr.wallets.api.walletsapi.domain.User;
//import com.kswr.wallets.api.walletsapi.repo.UserRepository;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//@Slf4j
//public class DataInitializer implements CommandLineRunner {
//
//    private UserRepository users;
//    private PasswordEncoder passwordEncoder;
//
//    public DataInitializer(UserRepository users, PasswordEncoder passwordEncoder) {
//        this.users = users;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//
//        this.users.save(User.builder()
//            .username("user")
//            .password(this.passwordEncoder.encode("password"))
//            .roles(Arrays.asList( "ROLE_USER"))
//            .build()
//        );
//
//        this.users.save(User.builder()
//            .username("admin")
//            .password(this.passwordEncoder.encode("password"))
//            .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
//            .build()
//        );
//
//        log.debug("printing all users...");
//        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
//    }
//}
