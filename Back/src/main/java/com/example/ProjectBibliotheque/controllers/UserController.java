package com.example.ProjectBibliotheque.controllers;
import com.example.ProjectBibliotheque.model.Person;
import com.example.ProjectBibliotheque.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private PersonService personService;

    //############################ CREATE ############################//

    @PostMapping("/register")
    public Person createPerson(@RequestBody Person person) {
        return personService.createUser(person.getUsername(),person.getPassword());
    }

    @PostMapping("/register/admin")
    public Person createAdmin(@RequestBody Person person) {
        return personService.createAdmin( person.getUsername(),person.getPassword());
    }


    // ALL USER WITH USER_ROLE
    @GetMapping("/user")
    public List<Person> getAllClient() {
        return personService.getUsers();
    }

    // SINGLE USER
    @GetMapping("/user/{id}")
    public Person getById(@PathVariable(value = "id") long id) {

        return personService.getUserById(id);
    }

    @GetMapping("/user/profil/{username}")
    public Person getByUserName(@PathVariable(value = "username") String username) {
        return personService.getByUsername(username);
    }

}
