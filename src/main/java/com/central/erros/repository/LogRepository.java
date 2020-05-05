package com.central.erros.repository;

import com.central.erros.model.Level;
import com.central.erros.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.net.URLConnection;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface LogRepository extends CrudRepository<Log,Long>, JpaRepository<Log, Long> ,PagingAndSortingRepository<Log, Long> {
    Page<Log> findAll(Specification<Log> specification, Pageable pageable);
    List<Log> findByTitle(String title);
    Page<Log> findByTitleContaining(String title, org.springframework.data.domain.Pageable pageable);
    Page<Log> findByOriginContaining(String origin, org.springframework.data.domain.Pageable pageable);
    Page<Log> findByLevelContaining(String level, org.springframework.data.domain.Pageable pageable);
    Page<Log> findByDescriptionContaining(String description, org.springframework.data.domain.Pageable pageable);



    //List<Log> findAllWithEventDateBefore( @Param("eventDate") Date eventDate);


    //Page<Log> findAllWithEventDateBeforeContaining(Date eventDate, org.springframework.data.domain.Pageable pageable);

    //Page<Log>findByEventDateContaining(Date eventDate, org.springframework.data.domain.Pageable pageable);
}

