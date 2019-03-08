package com.kswr.wallets.api.walletsapi.repo;

import com.kswr.wallets.api.walletsapi.domain.Avatar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Avatar save(Avatar avatar);
}
