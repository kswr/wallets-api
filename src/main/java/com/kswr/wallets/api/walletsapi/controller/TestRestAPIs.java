package com.kswr.wallets.api.walletsapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {

    @GetMapping("/api/test/msa")
    @PreAuthorize("hasRole('MSA') or hasRole('ADMIN')")
    public String msaAccess() {
        return ">>> MSA Content!";
    }

    @GetMapping("/api/test/rdsa")
    @PreAuthorize("hasRole('RDSA') or hasRole('ADMIN')")
    public String rdsaAccess() {
        return ">>> RDSA Content";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return ">>> Admin Content";
    }
}
