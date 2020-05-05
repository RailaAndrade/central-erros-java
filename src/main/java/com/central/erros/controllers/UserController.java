package com.central.erros.controllers;


import com.central.erros.model.User;
import com.central.erros.service.ResourceNotFoundException;
import com.central.erros.service.UnicidadeEmailException;
import com.central.erros.service.UserService;
import com.central.erros.service.unicidadeTokenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

import java.util.List;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    UserService userService;


    @PostMapping
    public ResponseEntity<?> insertUsers(@RequestBody User user) throws ResourceNotFoundException, UnicidadeEmailException, unicidadeTokenException {
        userService.userSave(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public Iterable<User> findAll(@PathParam("name")String name, Pageable pageable){

        if ( name!=null) {
            return this.userService.findByName(name, pageable);
        }
            return this.userService.findAll(pageable);


    }



    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        return ResponseEntity.ok(userService.findById(id));
    }


  /*  @GetMapping("token/{tokenAccess}")
    public ResponseEntity<?> findByTokenAccess(@PathVariable String tokenAccess) {

        return ResponseEntity.ok(userService.findByTokenAccess(tokenAccess));
    }
*/
}
