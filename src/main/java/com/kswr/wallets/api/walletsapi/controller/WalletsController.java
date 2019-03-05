package com.kswr.wallets.api.walletsapi.controller;

import com.kswr.wallets.api.walletsapi.domain.Wallet;
import com.kswr.wallets.api.walletsapi.service.WalletsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
public class WalletsController {

    private WalletsService walletsService;

    public WalletsController(WalletsService walletsService) {
        this.walletsService = walletsService;
    }

    @GetMapping("/{id}")
    public Wallet getWalletById(@PathVariable("id") Integer id) {
        return walletsService.getWalletById(id);
    }
}
