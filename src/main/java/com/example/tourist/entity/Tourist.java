package com.example.tourist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tourist {
    @Id
    private Long id;
    private String name;
    private String place;
    private String email;

    public Tourist() {}
    public Tourist(Long id, String name, String place, String email) {
        this.id = id; this.name = name; this.place = place; this.email = email;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
