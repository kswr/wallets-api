package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.Wallet;

public interface WalletsService {
    Wallet getWalletById(Long id);
}
