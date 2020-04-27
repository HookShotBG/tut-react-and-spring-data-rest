package com.gools.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
import java.util.Vector;

@Entity
public class Dep {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date dep_date;

    @NotNull
    private Date start_date;
    @NotNull
    private Date end_date;

    private String comments;
    private String notes;

    @NotNull
    private int active;

    //foreignkeys
    @ManyToOne
    @NotNull
    private Release release;
    @ManyToOne
    @NotNull
    private Location location;
    @ManyToOne
    @NotNull
    private Environment environment;

    @OneToMany
    @NotNull
    private List<DepTask> tasks;

    //TODO
    //scenario ID
    //status_id


    public Dep() {
    }

    public Dep(@NotNull Date dep_date, @NotNull Date start_date, @NotNull Date end_date, String comments, String notes, @NotNull int active, @NotNull Release release, @NotNull Location location, @NotNull Environment environment, List<DepTask> tasks) {
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

    public Date getDep_date() {
        return dep_date;
    }

    public void setDep_date(Date dep_date) {
        this.dep_date = dep_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
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

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public List<DepTask> getTasks() {
        return tasks;
    }

    public void setTasks(List<DepTask> tasks) {
        this.tasks = tasks;
    }
}
