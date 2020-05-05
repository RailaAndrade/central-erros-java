package com.central.erros.service.Imp;
import com.central.erros.model.User;

import com.central.erros.service.EmailNaoEncontradoException;
import com.central.erros.service.UnicidadeEmailException;
import com.central.erros.service.UserService;
import com.central.erros.repository.UserRepository;
import com.central.erros.service.unicidadeTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
public class UserServiceImp implements UserService , UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Autowired

    public UserServiceImp(UserRepository userRepository) {

        this.userRepository=userRepository;
    }

    @Override
    public User userSave(User user) throws unicidadeTokenException, UnicidadeEmailException {
        //return null;
        /*Optional<User>optional=userRepository.findByTokenAccess(user.getTokenAccess());
        if (optional.isPresent()){
            throw new unicidadeTokenException();
        }*/
        Optional<User>optional= Optional.ofNullable(userRepository.findByEmail(user.getEmail()));

        if (optional.isPresent()){
            throw new UnicidadeEmailException();
        }
        return userRepository.save(user);
    }

    @Override
    public User SearchByEmail(String email) throws EmailNaoEncontradoException {
        return userRepository.findByEmail(email);
    }





    @Override
    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    }
/*
    @Override
    public Optional<User> findByTokenAccess(String tokenAccess) {
        return this.userRepository.findByTokenAccess(tokenAccess);
    }


 */
    @Override
    public List<User> findAll(Pageable pageable) {
        return this.userRepository.findAll(pageable).getContent();
    }

    @Override
    public List<User> findByName(String nome, Pageable pageable) {
        return this.userRepository.findByNameContaining(nome, pageable).getContent();
    }

  /*  @Override
    public User findByEmail(String email) {
        return null;
    }*/


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return this.userRepository.findByEmail(email);
    }
}
