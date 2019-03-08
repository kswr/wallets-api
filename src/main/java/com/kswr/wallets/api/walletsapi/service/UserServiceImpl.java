package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.Avatar;
import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.domain.dtos.AvatarDTO;
import com.kswr.wallets.api.walletsapi.exception.FileSaveException;
import com.kswr.wallets.api.walletsapi.exception.NoSuchUserException;
import com.kswr.wallets.api.walletsapi.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public byte[] getAvatar(Long userId) {
        byte[] picture;
        if (repository.existsById(userId)) {
            byte[] source = repository.findById(userId).get().getAvatar().getPicture();
            picture = new byte[source.length];
            for (int i = 0; i<source.length; i++) {
                picture[i] = source[i];
            }
            return picture;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public boolean saveAvatar(MultipartFile file, Long userId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        User user = repository.findById(userId).orElse(null);
        try {
            if(fileName.contains("..")) {
                throw new FileSaveException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Avatar avatar = Avatar.builder().fileName(fileName).fileType(file.getContentType())
                    .picture(file.getBytes()).build();

            if (user != null) {
                user.setAvatar(avatar);
                return true;
            } else {
                throw new NoSuchUserException(userId);
            }
        } catch (IOException ex) {
            throw new FileSaveException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

}
