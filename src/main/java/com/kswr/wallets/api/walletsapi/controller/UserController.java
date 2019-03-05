package com.kswr.wallets.api.walletsapi.controller;

import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    private UserService userService;
    private PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user) {
        if (!userService.existsByUserName(user.getUsername())) {
            user.setPassword(encoder.encode(user.getPassword()));
            userService.save(user);
        }
    }

    @GetMapping("/allusers")
    public Set<String> getAllUserNames() {
        return userService.getAllUserNames();
    }


}
