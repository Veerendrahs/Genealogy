package com.example.demo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PersonDto 
{
    @NotEmpty(message="the name is required")
   public String personname;

   @NotNull(message="the name is required")
   public int age;

   
   public String child1;

   
   public String child2;

   @NotEmpty(message="the name is required")
   public String fathername;

   @DateTimeFormat(pattern = "yyyy-mm-dd")
   public Date createdAt;

   @NotEmpty(message="the name is required")
   public String address;
   
public String getPersonname() {
    return personname;
}
public void setPersonname(String personname) {
    this.personname = personname;
}
public int getAge() {
    return age;
}
public void setAge(int age) {
    this.age = age;
}
public String getchild1() {
    return child1;
}
public void setchild1(String child1) {
    this.child1 = child1;
}
public String getchild2() {
    return child2;
}
public void setchild2(String child2) {
    this.child2 = child2;
}
public String getFathername() {
    return fathername;
}
public void setFathername(String fathername) {
    this.fathername = fathername;
}
public Date getCreatedAt() {
    return createdAt;
}
public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
}
public String getAddress() {
    return address;
}
public void setAddress(String address) {
    this.address = address;
}

   
}
