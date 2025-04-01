package com.example.nkomazi_businesses.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("BUSINESSES")
public class Business {

    @Id
    private Integer id;

    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("location")
    private String location;
    @JsonProperty("contact")
    private String contact;
    @JsonProperty("owner")
    private String owner;

    public Business() {
    }



    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getOwner() {
        return owner;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void name(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
