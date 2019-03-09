package com.kswr.wallets.api.walletsapi.service;

import com.kswr.wallets.api.walletsapi.domain.Avatar;
import com.kswr.wallets.api.walletsapi.domain.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    boolean save(User user);
    Avatar getAvatar(Long userId);
    boolean saveAvatar(MultipartFile file, Long userId);
}
