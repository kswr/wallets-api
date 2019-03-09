package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.Avatar;
import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.exception.FileSaveException;
import com.kswr.wallets.api.walletsapi.exception.UserIdNotFoundException;
import com.kswr.wallets.api.walletsapi.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    public Avatar getAvatar(Long userId) {
        Avatar avatar;
        if (repository.existsById(userId)) {
            Avatar temp = repository.findById(userId).get().getAvatar();
            avatar = Avatar.builder().fileType(temp.getFileType()).picture(temp.getPicture()).build();
            return avatar;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public boolean saveAvatar(MultipartFile file, Long userId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        User user = repository.findById(userId).orElseThrow(() -> new UserIdNotFoundException("User with id " + userId + " not found"));
        try {
            if(fileName.contains("..")) {
                throw new FileSaveException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Avatar avatar = Avatar.builder().fileName(fileName).fileType(file.getContentType())
                    .picture(file.getBytes()).build();

            user.setAvatar(avatar);
            return true;
        } catch (IOException ex) {
            throw new FileSaveException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

}
