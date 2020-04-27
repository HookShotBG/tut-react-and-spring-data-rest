package com.gools.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int sequence;
    private String statusName;
    private String statusColor;
    private int doneFlag;

    public TaskStatus() {
    }

    public TaskStatus(int sequence, String statusName, String statusColor, int doneFlag) {
        this.sequence = sequence;
        this.statusName = statusName;
        this.statusColor = statusColor;
        this.doneFlag = doneFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public int getDoneFlag() {
        return doneFlag;
    }

    public void setDoneFlag(int doneFlag) {
        this.doneFlag = doneFlag;
    }
}
