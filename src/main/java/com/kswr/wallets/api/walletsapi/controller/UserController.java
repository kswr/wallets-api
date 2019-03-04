package com.kswr.wallets.api.walletsapi.controller;

import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/signup")
//    public void signUp(@RequestBody User user) {
//
//    }

    @GetMapping("/allusers")
    public Set<String> getAllUsernames() {
        return userService.getAllUsernames();
    }


}
