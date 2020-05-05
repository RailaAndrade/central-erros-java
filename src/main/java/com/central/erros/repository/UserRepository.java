package com.central.erros.repository;

import com.central.erros.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    //Optional<User> findByTokenAccess( String tokenAccess);
    User findByEmail(String email);
    Page<User> findAll(org.springframework.data.domain.Pageable pageable);
    Page<User> findByNameContaining(String name, org.springframework.data.domain.Pageable pageable);
    List<User> findByName(String name);

}
