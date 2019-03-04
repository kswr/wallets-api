package com.kswr.wallets.api.walletsapi.repo;

import com.kswr.wallets.api.walletsapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashSet;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    User save(User user);

    @Query(value = "SELECT username FROM User")
    HashSet<String> getAllUsernames();



}
