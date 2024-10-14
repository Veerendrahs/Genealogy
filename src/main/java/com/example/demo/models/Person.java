package com.example.demo.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person 
{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public int id;
    
   public String personname;
   public int age;
   public String child1;
   public String child2;
   public String fathername;
   public Date createdAt;
   public String address;
 
public Person() 
{
}

public Person(int id, String personname, int age, String child1, String child2, String fathername, Date createdAt,
        String address) {
    this.id = id;
    this.personname = personname;
    this.age = age;
    this.child1 = child1;
    this.child2 = child2;
    this.fathername = fathername;
    this.createdAt = createdAt;
    this.address = address;
}
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
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
public String getChild1() {
    return child1;
}
public void setChild1(String child1) {
    this.child1 = child1;
}
public String getChild2() {
    return child2;
}
public void setChild2(String child2) {
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

@Override
public String toString() {
    return "Person [id=" + id + ", personname=" + personname + ", age=" + age + ", child1=" + child1 + ", child2="
            + child2 + ", fathername=" + fathername + ", createdAt=" + createdAt + ", address=" + address + "]";
}
   



}
