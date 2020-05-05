package com.central.erros.controllers;


import com.central.erros.model.Level;
import com.central.erros.model.Log;
import com.central.erros.model.User;
import com.central.erros.repository.LogRepository;
import com.central.erros.service.LogService;
import com.central.erros.service.ResourceNotFoundException;
import com.central.erros.service.UnicidadeEmailException;
import com.central.erros.service.unicidadeTokenException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/log")
public class LogController {



    @Autowired
    private LogService logService;
    @Autowired
    private LogRepository logRepository;

    //salvar
    @PostMapping
    public ResponseEntity<?> insertLog(@RequestBody Log log) throws ResourceNotFoundException {
        Log savedEvent = this.logRepository.save(log);
        return ResponseEntity.ok(log);
    }

    //atualizar
    @PutMapping
    public ResponseEntity<Log> update(@Valid @RequestBody Log log) {
        return new ResponseEntity<Log>(this.logRepository.save(log), HttpStatus.ACCEPTED);
    }


    //localizar pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Log> findById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return new ResponseEntity<Log>(this.logRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException()), HttpStatus.OK);
    }

    //deletar
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.logRepository.deleteById(id);
    }

    //lista todos os logs por parametro


  /*
    private String description;
    private String logEvent;
    private String origin;
    private Date eventDate;


   */

    @GetMapping
    @ApiOperation("Lista todos os logs")
    public Iterable<Log> findAll(@PathParam("title") String title, @PathParam("origin") String origin,  @PathParam("level") String level, @PathParam("description") String description, @PathParam("eventDate") Date eventDate, Pageable pageable){
        if (title != null) {
            return this.logService.findByTitle(title.toString(), pageable);
        }
        if (origin != null) {
            return this.logService.findByOrigin(origin.toString(), pageable);
        }

        if (level!= null) {
            return this.logService.findByLevel(level.toString(), pageable);
        }

        if (description!= null) {
            return this.logService.findByDescription(description.toString(), pageable);
        }


        return this.logRepository.findAll(pageable);


    }





}
