package com.example.swaggerprovider.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.List;

public class Pet implements Serializable {
    private Long id;
    private String name;
    private User user;
    @JsonManagedReference
    private List<Visit> visits;

    public Pet(Long id,
               String name,
               User user,
               List<Visit> visits) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.visits = visits;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Pet{" + "id=" + id + ", name='" + name + '\'' + ", user=" + user + ", visits=" + visits + '}';
    }
}
