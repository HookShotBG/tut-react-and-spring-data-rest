package com.com.gools.data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Environment {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String name;
    private String solution;
    private String description;

    //foreign keys
    @ManyToOne
    private Location location;
    @ManyToOne
    private Release release;

    @NotNull
    private int active;
    @NotNull
    private int visible;

    public Environment() {
    }

    public Environment(String name, String solution, String description, Location location, Release release, @NotNull int active, @NotNull int visible) {
        this.name = name;
        this.solution = solution;
        this.description = description;
        this.location = location;
        this.release = release;
        this.active = active;
        this.visible = visible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }
}
