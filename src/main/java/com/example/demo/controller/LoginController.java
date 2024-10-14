package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Person;
import com.example.demo.models.PersonRegister;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.PersonRepository;

import jakarta.validation.Valid;

@Controller
public class LoginController 
{
    @Autowired
    LoginRepository repo;
    @Autowired
    PersonRepository personrepo;

    @GetMapping({"","/","/login"})
    public String loginDisplay()
    {
        return "login.html";
    }
    @GetMapping("/map-login")
    public String createCancel(Model model)
    {
        List<Person> person=personrepo.findAll( );
        model.addAttribute("persons", person);
        return"/persons";
    }

    @PostMapping("/map-login")
    public String loginValid(@RequestParam String email,@RequestParam String password,Model model)
    {
        PersonRegister pr=repo.findByEmail(email);
        String passworddb=pr.getPassword();
        if(password.equals(passworddb))
        {
            List<Person> person=personrepo.findAll();
            model.addAttribute("persons", person);
            return"/persons.html";
        }
        return"";
    }

    @GetMapping("/register")
    public String registerDisplay(Model model)
    {
        PersonRegister personregister=new PersonRegister();
        model.addAttribute("personregister", personregister);
        return "/register.html";
    }

    @PostMapping("/addperson")
    public String addRegister(@Valid @ModelAttribute("personregister") PersonRegister personregister, BindingResult result, Errors errors)
    {
        if(errors.hasErrors())
        {
            return"/register.html";
        }
        repo.save(personregister);
        return "/login.html";
    }
}
