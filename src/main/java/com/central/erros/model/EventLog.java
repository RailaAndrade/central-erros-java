package com.central.erros.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "event_log")
public class EventLog {

    @Id
    @Column(name = "id")
    private long id;

    private String text;


   //@OneToOne(mappedBy = "eventLog")


    public Log getLog() {
        return log;
    }

    public void setLog(Log log) {
        this.log = log;
    }
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private Log log;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
