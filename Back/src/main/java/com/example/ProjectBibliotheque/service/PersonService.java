package com.example.ProjectBibliotheque.service;


import com.example.ProjectBibliotheque.model.Person;
import com.example.ProjectBibliotheque.model.Role;
import com.example.ProjectBibliotheque.repository.PersonRepository;
import com.example.ProjectBibliotheque.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class PersonService {

    private PersonRepository personRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    //CREATE************************************************************************************

    public Person createUser( String username, String password){
        Person personInDB =this.personRepository.findByUsername(username);
        if(personInDB !=null) throw new RuntimeException("Person already exists");
        Person person =new Person();
        person.setUsername(username);

        person.setPassword(bCryptPasswordEncoder.encode(password));
        this.personRepository.save(person);
        addRoleToUser(username,"USER");
        return person;
    }


    public Person createAdmin( String username, String password) {
        Person personInDB =this.personRepository.findByUsername(username);
        if(personInDB !=null) throw new RuntimeException("Person already exists");
        Person person =new Person();
        person.setUsername(username);
        person.setPassword(bCryptPasswordEncoder.encode(password));
        this.personRepository.save(person);
        addRoleToUser(username,"ADMIN");
        return person;
    }



// GET
    public List<Person> getUsers(){
        return personRepository.findAll();
    }

    public Person getUserById(@PathVariable(name="id") Long id){
        return personRepository.findById(id).get();
    }

    public Person getByUsername(String username) {
        return personRepository.findByUsername(username);
    }
    public Role save(Role role) {
        return this.roleRepository.save(role);
    }
    public void addRoleToUser(String username, String roleName) {
        Person person =this.personRepository.findByUsername(username);
        Role role=this.roleRepository.findByRole(roleName);
        person.setRole(role);
    }
/*
    public Person getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Person person = this.getByUsername(auth.getName());
        return person;
    }
*/

/**
    // UPDATE
    public Person updateUser (@PathVariable(name="id") Long id, @RequestBody Person u){
        u.setIdUser(id);
        return personRepository.save(u);
    }

    //ne peut pas être delete si elle est lié à une réservation -- on va dire pour le moment qu'on peut pas supprimer de person
    public void deleteUser (@PathVariable(name="id") Long id){
        try {
            personRepository.deleteById(id);
        } catch (Exception exception){

            System.out.println("cet utilisaeur possède une réservation");
        }
    }

**/


}
