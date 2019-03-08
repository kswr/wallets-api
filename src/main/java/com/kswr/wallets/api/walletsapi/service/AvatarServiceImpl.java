package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.Avatar;
import com.kswr.wallets.api.walletsapi.exception.FileSaveException;
import com.kswr.wallets.api.walletsapi.repo.AvatarRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AvatarServiceImpl implements AvatarService{

    private AvatarRepository repository;

    public AvatarServiceImpl(AvatarRepository repository) {
        this.repository = repository;
    }

    public Avatar saveAvatar(MultipartFile file, Long userId) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Avatar avatar = Avatar.builder().fileName(fileName).fileType(file.getContentType())
                    .picture(file.getBytes()).build();
            return repository.save(avatar);
        } catch (IOException ex) {
            throw new FileSaveException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


}
