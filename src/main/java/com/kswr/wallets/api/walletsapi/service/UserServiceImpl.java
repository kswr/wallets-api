package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.Avatar;
import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.domain.dtos.AvatarDTO;
import com.kswr.wallets.api.walletsapi.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public boolean updateAvatar(AvatarDTO avatarDto) {
        User existingUser = repository.findById(avatarDto.getUserId()).orElse(null);
        if (existingUser != null) {
            existingUser.setAvatar(Avatar.builder().picture(avatarDto.getAvatar()).build());
            log.debug(avatarDto.toString());
            log.debug(existingUser.toString());
            repository.save(existingUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Set<String> getAllUserNames() {
        return repository.getAllUserNames();
    }

    @Transactional
    @Override
    public Avatar getAvatar(Long id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get().getAvatar();
        } else {
            return null;
        }
    }

}
