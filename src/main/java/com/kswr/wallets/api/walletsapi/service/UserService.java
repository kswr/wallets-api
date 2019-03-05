package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;

import java.util.Set;

public interface UserService {
    void save(User user);
    Set<String> getAllUserNames();
}
