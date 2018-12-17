package com.kswr.wallets.api.walletsapi.controller;

import com.kswr.wallets.api.walletsapi.model.Wallet;
import com.kswr.wallets.api.walletsapi.service.WalletsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
public class WalletsController {

    @Autowired
    WalletsService walletsService;

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable("id") Integer id) {
        return walletsService.getWalletById(id);
    }
}
