package com.central.erros.service;

import com.central.erros.model.Level;
import com.central.erros.model.Log;
import com.central.erros.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface LogService {


    List<Log> findByTitle(String title, Pageable  pageable);

    List<Log> findByOrigin(String origin, Pageable  pageable);

    List<Log> findByLevel(String toString, Pageable pageable);

    //List<Log> findByEventDate(String eventDate, Pageable pageable) throws ParseException;

    List<Log> findByDescription(String description, Pageable pageable);

    //List<Log> findAllWithEventDateBefore(@Param("eventDate") Date eventDate);

   // private String logEvent;




}
