package com.example.ProjectBibliotheque.controllers;
import com.example.ProjectBibliotheque.model.Person;
import com.example.ProjectBibliotheque.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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



        /*@PostMapping("/user")
        public Person createPerson(@RequestBody String firstName, String lastName, String username, String password,String phone, String mail) {
                return personService.createPerson( firstName,  lastName,  username,  password, phone,  mail);
        }*/
        /* bon
        @PostMapping("/user")
        public Person createPerson(@RequestBody Person person) {
                return personService.createPerson( person.getFirstName() ,  person.getLastName(), person.getUsername(),person.getPassword(),person.getPhone(), person.getMail());
        }*/
    //############################# READ #############################//

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

    // GET CURRENT USER
  /*      @GetMapping("/person/current_user")
        public Person getCurrentUser() {
            return userService.getCurrentUser();
        }
*/


  /**

    //############################ UPDATE ############################//
    @PutMapping("/user/{id}")
    public Person update(@PathVariable(value = "id") long id, @RequestBody Person person) {
        return personService.updateUser(id, person);
    }



    //############################ DELETE ############################//
    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        personService.deleteUser(id);
    }
   **/

}
