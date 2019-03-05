package com.kswr.wallets.api.walletsapi.security;

import com.kswr.wallets.api.walletsapi.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository users;

    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return this.users.findByUserName(userName)
            .orElseThrow(() -> new UsernameNotFoundException("Username: " + userName + " not found"));
    }
}
