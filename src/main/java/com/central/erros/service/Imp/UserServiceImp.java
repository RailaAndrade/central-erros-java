package com.central.erros.service.Imp;
import com.central.erros.model.User;
import com.central.erros.service.EmailNaoEncontradoException;
import com.central.erros.service.UnicidadeEmailException;
import com.central.erros.service.UserService;
import com.central.erros.repository.UserRepository;
import com.central.erros.service.unicidadeTokenException;

import java.util.Optional;


public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {

        this.userRepository=userRepository;
    }

    @Override
    public User userSave(User user) throws unicidadeTokenException, UnicidadeEmailException {
        //return null;
        Optional<User>optional=userRepository.findByToken(user.getTokenAccess());
        if (optional.isPresent()){
            throw new unicidadeTokenException();
        }
       optional=userRepository.findByEmail(user.getEmail());

        if (optional.isPresent()){
            throw new UnicidadeEmailException();
        }
        return userRepository.save(user);
    }

    @Override
    public User SearchByEmail(String email) throws EmailNaoEncontradoException {
        Optional<User> optional= userRepository.findByEmail(email);
        return optional.orElseThrow(()-> new EmailNaoEncontradoException());
    }
}
