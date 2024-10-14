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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Person;
import com.example.demo.models.PersonDto;
import com.example.demo.repository.PersonRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class PersonController 
{
    @Autowired
    PersonRepository repo;

    @GetMapping("/tree")
    public String showPersonList(Model model)
    {
       List<Person> person=repo.findAll();
        model.addAttribute("person", person);
        return "/tree.html";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model)
    {
        PersonDto persondto=new PersonDto();
        model.addAttribute("persondto", persondto);
        return "/createperson";
    }

    @PostMapping("/create")
    public String createProduct(@Valid @ModelAttribute("persondto") PersonDto persondto,  BindingResult result,Errors errors,Model model)
    {
        if(result.hasErrors())
        {
            return "/createperson";
        }
        else
        {
            Person person=new Person();
            person.setPersonname(persondto.getPersonname());
            person.setAge(persondto.getAge());
            person.setChild1(persondto.getchild1());
            person.setChild2(persondto.getchild2());
            person.setFathername(persondto.getFathername());
            person.setCreatedAt(persondto.getCreatedAt());
            person.setAddress(persondto.getAddress());
            repo.save(person);
        }
       
        return "redirect:/map-login";
    }

    @GetMapping("/edit")
    public String showEditPage(Model model, @RequestParam int id)
    {
        try
        {
           Person person=repo.findById(id).get();
           model.addAttribute("person", person);
           PersonDto persondto=new PersonDto();
           persondto.setPersonname(person.getPersonname());
           persondto.setAge(person.getAge());
           persondto.setchild1(person. getChild1());
           persondto.setchild2(person.getChild2());
           persondto.setFathername(person.getFathername());
           persondto.setCreatedAt(person.getCreatedAt());
           persondto.setAddress(person.getAddress());
           model.addAttribute("persondto", persondto);
        }
        catch(Exception ex)
        {
            System.out.println("Exceptoin: "+ex.getMessage());
            return "redirect:/persons";
        }
        return "editperson";
    }

    @PostMapping("/edit")
    public String updateProduct(Model model, @RequestParam int id, 
                               @Valid @ModelAttribute PersonDto persondto, 
                               BindingResult result,
                               Errors errors)
    {
        try
        {
            Person person=repo.findById(id).get();
            model.addAttribute("person", person);
            model.addAttribute("persondto", persondto);

            if(result.hasErrors())
            {
                System.out.println(result);
                System.out.println("--------------------------------------------------------------------");
                return "/editperson";
            }
            person.setPersonname(persondto.getPersonname());
            person.setAge(persondto.getAge());
            person.setChild1(persondto.getchild1());
            person.setChild2(persondto.getchild2());
            person.setFathername(persondto.getFathername());
            person.setCreatedAt(persondto.getCreatedAt());
            person.setAddress(persondto.getAddress());
            repo.save(person);

        }
        catch(Exception ex)
        {
            System.out.println("Exception : "+ ex.getMessage());
        }  
        
        return "redirect:/map-login";
    } 
    
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam int id)
    {
        try
        {
            Person person=repo.findById(id).get();
            repo.delete(person);

        }
        catch (Exception ex) 
        {
            System.out.println("Exception: "+ex.getMessage());
        }
        return "redirect:/map-login";
    }
    
}
