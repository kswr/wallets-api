package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;

import java.util.Set;

public interface UserService {
    User saveUser(User user);
    Set<String> getAllUsernames();
}
