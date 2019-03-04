package com.kswr.wallets.api.walletsapi.repo;

import com.kswr.wallets.api.walletsapi.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletsRepo extends JpaRepository<Wallet, Integer> {

}
