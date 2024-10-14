package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class PersonRegister 
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    int id;
    @NotBlank(message = " Please enter required!")
    String username;

    @NotBlank(message = "  Please enter required!")
    String email;

    @NotBlank(message = "  Please enter required!")
    String password;
    
    @NotBlank(message = "  Please enter required!")
    String address;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
}
                      