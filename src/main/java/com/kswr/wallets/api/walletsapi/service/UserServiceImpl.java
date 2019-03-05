package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.repo.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;
    private PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void save(User user) {
        if (!repository.existsByUserName(user.getUsername())) {
            user.setPassword(encoder.encode(user.getPassword()));
            repository.save(user);
        }
    }

    @Override
    public Set<String> getAllUserNames() {
        return repository.getAllUserNames();
    }

}
