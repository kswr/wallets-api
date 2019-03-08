package com.kswr.wallets.api.walletsapi.service;


import com.kswr.wallets.api.walletsapi.domain.Avatar;
import org.springframework.web.multipart.MultipartFile;

public interface AvatarService {
    Avatar saveAvatar(MultipartFile file, Long userId);
}
