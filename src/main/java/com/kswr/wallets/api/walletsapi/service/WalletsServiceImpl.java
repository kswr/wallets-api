package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.exception.ResourceNotFoundException;
import com.kswr.wallets.api.walletsapi.domain.Wallet;
import com.kswr.wallets.api.walletsapi.repo.WalletsRepo;
import org.springframework.stereotype.Service;

@Service
public class WalletsServiceImpl implements WalletsService {

    private WalletsRepo walletsRepo;

    public WalletsServiceImpl(WalletsRepo walletsRepo) {
        this.walletsRepo = walletsRepo;
    }

    public Wallet getWalletById(Integer id) {
        return walletsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Wallet " + id + " not found"));
    }
}
