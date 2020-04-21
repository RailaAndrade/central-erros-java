package com.central.erros.repository;

import com.central.erros.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //User save(User user);

    Optional<User> findByToken(String token);
    Optional<User> findByEmail(String email);

}
