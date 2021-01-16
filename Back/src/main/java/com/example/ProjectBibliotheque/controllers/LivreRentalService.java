package com.example.ProjectBibliotheque.controllers;


import com.example.ProjectBibliotheque.repository.LivreRepository;
import com.example.ProjectBibliotheque.model.Livre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LivreRentalService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    public LivreRentalService(LivreRepository livreRepository) { this.livreRepository = livreRepository;}

    @GetMapping("/")
    public String hello(){
        return "HelloWorld final 5";
    }

    @GetMapping("/books")
    public List<Livre> getListeOfBook(){
        return livreRepository.findAll();
    }
    
    @DeleteMapping("/book")
    public void removeBook(@RequestBody Livre livre){
            livreRepository.delete(livre);
    }
    

    @PostMapping("/book")
    public ResponseEntity<String> addLivre(@RequestBody Livre livre) {
        try {
            livreRepository.save(livre);
          jmsTemplate.convertAndSend("Bibliotheque-queue", livre);
            System.out.println(livre);
            System.out.println(livre.toString() + "envoyez dans la file Mq"+ ":" + " " + livreRepository.count());

            return new ResponseEntity<>("Opérationn réussi.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/livre/{titre}")
    public Livre getLivre(@PathVariable(value = "titre") String titre){
        for(Livre livre: livreRepository.findAll()){
            if(livre.getTitre().equals(titre)){
                return livre;
            }
        }
        return null;
    }

}

