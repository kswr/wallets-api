package com.kswr.wallets.api.walletsapi.controller;

import com.kswr.wallets.api.walletsapi.domain.Avatar;
import com.kswr.wallets.api.walletsapi.domain.User;
import com.kswr.wallets.api.walletsapi.service.UserService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class UserController {

    private UserService userService;
    private PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if (userService.save(user)) {
            return ok("User registered successfully");
        } else {
            return new ResponseEntity<>("Email or username are already in use", HttpStatus.BAD_REQUEST);
        }
    }

    // todo probably unnecessary endpoint
    @GetMapping("/me")
    public ResponseEntity currentUser(@AuthenticationPrincipal User user){
        Map<Object, Object> model = new HashMap<>();
        model.put("username", user.getUsername());
        model.put("roles", user.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(toList())
        );
        model.put("email", user.getEmail());
        model.put("firstName", user.getFirstName());
        model.put("lastName", user.getLastName());
        return ok(model);
    }

    @GetMapping(path = "/getavatar/{userId}")
    public ResponseEntity getAvatarId(@PathVariable("userId") String userId) {
        Avatar avatar = userService.getAvatar(Long.valueOf(userId));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(avatar.getFileType()))
                .body(new ByteArrayResource(avatar.getPicture()));
    }

    @PostMapping("/saveavatar")
    public ResponseEntity saveAvatar(@AuthenticationPrincipal User user, @RequestParam("file") MultipartFile file) {
        if(userService.saveAvatar(file, user.getId())) {
            return ok("Avatar updated");
        } else {
            return new ResponseEntity<>("Update unsuccessful, try again later", HttpStatus.BAD_REQUEST);
        }

    }
}
