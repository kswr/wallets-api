package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.domain.dtos.AvatarDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface UserService {
    boolean save(User user);
    Set<String> getAllUserNames();
    boolean updateAvatar(AvatarDTO avatarDto);
    byte[] getAvatar(Long userId);
    boolean saveAvatar(MultipartFile file, Long userId);
}
