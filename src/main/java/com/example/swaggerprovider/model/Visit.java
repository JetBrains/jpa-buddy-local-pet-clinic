package com.example.swaggerprovider.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class Visit implements Serializable {
    private Long id;
    private OffsetDateTime date;
    private String veterinarianName;
    private String clinicName;

    public Visit(Long id,
                 OffsetDateTime date,
                 String veterinarianName,
                 String clinicName) {
        this.id = id;
        this.date = date;
        this.veterinarianName = veterinarianName;
        this.clinicName = clinicName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getVeterinarianName() {
        return veterinarianName;
    }

    public void setVeterinarianName(String veterinarianName) {
        this.veterinarianName = veterinarianName;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    @Override
    public String toString() {
        return "Visit{" + "id=" + id + ", date=" + date + ", veterinarianName='" + veterinarianName + '\'' + ", clinicName='" + clinicName + '\'' + '}';
    }
}