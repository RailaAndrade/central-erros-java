package com.central.erros.service;

import com.central.erros.model.User;


import java.util.List;
import java.util.Optional;


public interface UserService {
    //User saveUser(User user);



    User userSave(User user) throws ResourceNotFoundException, unicidadeTokenException,UnicidadeEmailException;

    User SearchByEmail(String email) throws EmailNaoEncontradoException;

    List<User> findAll(org.springframework.data.domain.Pageable pageable);

    Optional<User> findById(Long id);

   // Optional<User> findByTokenAccess(String tokenAccess);

    List<User> findByName(String name, org.springframework.data.domain.Pageable  pageable);

   // User findByEmail(String email);

    //Optional<User> loadUserByUsername (String email);
}
