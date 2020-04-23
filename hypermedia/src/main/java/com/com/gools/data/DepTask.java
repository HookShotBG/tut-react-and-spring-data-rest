package com.com.gools.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class DepTask {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String short_description;
    private String long_description;

    @NotNull
    private int sequence;

    //foreign keys


    @NotNull
    @ManyToOne
    private TaskOrder task_order; //PRE DEP / INTER DEP / POST DEP
    @NotNull
    @ManyToOne
    private TaskStatus task_status; //open / pending / done / not needed

    @NotNull
    private String background_color;

    @NotNull
    private int active;

    public DepTask() {
    }

    public DepTask(String short_description, String long_description, @NotNull int sequence, @NotNull TaskOrder task_order, @NotNull TaskStatus task_status, @NotNull String background_color, @NotNull int active) {
        this.short_description = short_description;
        this.long_description = long_description;
        this.sequence = sequence;
        this.task_order = task_order;
        this.task_status = task_status;
        this.background_color = background_color;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public TaskOrder getTask_order() {
        return task_order;
    }

    public void setTask_order(TaskOrder task_order) {
        this.task_order = task_order;
    }

    public TaskStatus getTask_status() {
        return task_status;
    }

    public void setTask_status(TaskStatus task_status) {
        this.task_status = task_status;
    }

    public String getBackground_color() {
        return background_color;
    }

    public void setBackground_color(String background_color) {
        this.background_color = background_color;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
