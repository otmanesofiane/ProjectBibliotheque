package com.example.ProjectBibliotheque;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivreRentalService {



    // private List<Car> cars = new ArrayList<Car>();

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    LivreRepository livreRepository;

    @Autowired
    public LivreRentalService(LivreRepository livreRepository) { this.livreRepository = livreRepository;}

    @GetMapping("/livres")
    public List<Livre> getListeOfBook(){
        return livreRepository.findAll();
    }

    @PostMapping("/livres")
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
/**
 @PutMapping("/livre/{titre}")
 public void rent(@PathVariable("titre") String titre, @RequestParam(value="rent",
 required = true)boolean rent, @RequestBody Dates dates){
 for(Livre livre: livreRepository.findAll()){
 if(livre.getTitre().equals(titre)){
 livre.setDates(dates);
 livre.setRented(true);
 }
 }
 }**/

    /**
     @PostMapping("/livre")
     public void addCar(@RequestBody Livre livre) {
     System.out.println(livre);
     livreRepository.save(livre);
     livreRepository.count();
     //carRepository.findAll().add(car);
     jmsTemplate.convertAndSend("soso-queue-Biblio2", livre.toString());
     }

     **/




}

