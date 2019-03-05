package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;

import java.util.Set;

public interface UserService {
    User save(User user);
    Set<String> getAllUserNames();
    boolean existsByUserName(String userName);
}
