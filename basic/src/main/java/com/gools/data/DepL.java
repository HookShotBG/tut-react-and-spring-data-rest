package com.gools.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;

@Entity
public class DepL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String dep_date;

    @NotNull
    private String start_date;
    @NotNull
    private String end_date;

    private String comments;
    private String notes;

    @NotNull
    private int active;

    //foreignkeys

    @NotNull
    private String release;

    @NotNull
    private String location;

    @NotNull
    private String environment;


    @NotNull
    private String tasks;

    //TODO
    //scenario ID
    //status_id


    public DepL() {
    }

    public DepL(String dep_date, String start_date, String end_date, String comments, String notes, @NotNull int active, @NotNull String release, @NotNull String location, @NotNull String environment, @NotNull String tasks) {
        this.dep_date = dep_date;
        this.start_date = start_date;
        this.end_date = end_date;
        this.comments = comments;
        this.notes = notes;
        this.active = active;
        this.release = release;
        this.location = location;
        this.environment = environment;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDep_date() {
        return dep_date;
    }

    public void setDep_date(String dep_date) {
        this.dep_date = dep_date;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }
}
