package com.kswr.wallets.api.walletsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WalletsApiApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(WalletsApiApplication.class, args);
    }
}
