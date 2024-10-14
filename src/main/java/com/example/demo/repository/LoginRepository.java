package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PersonRegister;

@Repository
public interface LoginRepository extends JpaRepository<PersonRegister,Integer>
{

    PersonRegister findByEmail(String email);

}
