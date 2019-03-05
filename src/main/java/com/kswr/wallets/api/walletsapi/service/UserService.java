package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface UserService {
    boolean save(User user);
    Set<String> getAllUserNames();
}
