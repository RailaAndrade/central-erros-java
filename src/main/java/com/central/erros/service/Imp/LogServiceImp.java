package com.central.erros.service.Imp;


import com.central.erros.model.Level;
import com.central.erros.model.Log;
import com.central.erros.repository.LogRepository;
import com.central.erros.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogServiceImp implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Log> findByTitle(String title, Pageable pageable) {
        return this.logRepository.findByTitleContaining(title, pageable).getContent();
    }

    @Override
    public List<Log> findByOrigin(String origin, Pageable pageable) {
        return this.logRepository.findByOriginContaining(origin, pageable).getContent();
    }

    @Override
    public List<Log> findByLevel(String level, Pageable pageable) {
        return this.logRepository.findByLevelContaining(level, pageable).getContent();
    }




    /* @Override
     public List<Log> findByEventDate(Date eventDate, Pageable pageable) {
         return this.logRepository.findByEventDateContaining(eventDate, pageable).getContent();
     }
 */
    @Override
    public List<Log> findByDescription(String description, Pageable pageable) {
        return this.logRepository.findByDescriptionContaining(description, pageable).getContent();
    }



    /*@Override
    public List<Log> findAllWithEventDateBefore(Date eventDate, Pageable pageable) {
        return this.logService.(eventDate, pageable).getContent();
    }*/
}
