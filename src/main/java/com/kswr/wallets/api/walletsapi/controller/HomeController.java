package com.kswr.wallets.api.walletsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping()
    public String getApiWelcome() {
        return "Welcome to Wallets RESTful API";
    }
}
