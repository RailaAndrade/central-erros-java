package com.central.erros.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="log")
public class Log {


   @Id
   @NotNull
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    private String title;
    private String description;
   // private String logEvent;
    private String origin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date eventDate;


    @Enumerated(EnumType.STRING)
    private Level level;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }


   /* @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "event_log_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})*/

    @OneToOne(mappedBy = "log", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @NotNull
    private EventLog eventLog;

    public EventLog getEventLog() {
        return eventLog;
    }

    public Long getId() {
        return id;
    }

    public void setEventLog(EventLog eventLog) {
        if(eventLog !=null){
            eventLog.setLog(this);
        }
        this.eventLog = eventLog;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }



    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public String getLogEvent() {
        return logEvent;
    }

    public void setLogEvent(String logEvent) {
        this.logEvent = logEvent;
    }
*/
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
