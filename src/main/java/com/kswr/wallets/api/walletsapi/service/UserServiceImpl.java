package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public Set<String> getAllUserNames() {
        return repository.getAllUserNames();
    }

    @Override
    public boolean existsByUserName(String userName) {
        return repository.existsByUserName(userName);
    }
}
