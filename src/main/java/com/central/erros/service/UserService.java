package com.central.erros.service;

import com.central.erros.model.User;

public interface UserService {
    //User saveUser(User user);



    User userSave(User user) throws unicidadeTokenException,UnicidadeEmailException;

    User SearchByEmail(String email) throws EmailNaoEncontradoException;
}
