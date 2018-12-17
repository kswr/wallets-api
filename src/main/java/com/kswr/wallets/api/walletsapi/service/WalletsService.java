package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.repo.WalletsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletsService {

    @Autowired
    WalletsRepo walletsRepo;
}
