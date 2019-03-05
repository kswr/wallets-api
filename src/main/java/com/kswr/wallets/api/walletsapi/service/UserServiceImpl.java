package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class UserServiceImpl implements UserService{

    private UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean save(User user) {
        if (!repository.existsByUserName(user.getUsername()) && !repository.existsByEmail(user.getEmail())) {
            repository.save(user);
            System.out.println("Saved user");
            log.debug("Saved user " + user.toString());
            return true;
        } else {
            log.debug("Didn't save user " + user.toString());
            return false;
        }
    }

    @Override
    public Set<String> getAllUserNames() {
        return repository.getAllUserNames();
    }

}
