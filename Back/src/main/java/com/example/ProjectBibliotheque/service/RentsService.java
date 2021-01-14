package com.example.ProjectBibliotheque.service;

import com.example.ProjectBibliotheque.model.Livre;
import com.example.ProjectBibliotheque.model.Person;
import com.example.ProjectBibliotheque.model.Rent;
import com.example.ProjectBibliotheque.model.DateDTO;
import com.example.ProjectBibliotheque.repository.LivreRepository;
import com.example.ProjectBibliotheque.repository.PersonRepository;
import com.example.ProjectBibliotheque.repository.RentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RentsService {

    RentsRepository rentsRepository;
    PersonRepository personRepository;
    LivreRepository livreRepository;

    @Autowired
    public RentsService(RentsRepository rentsRepository, PersonRepository personRepository, LivreRepository livreRepository) {
        super();
        this.rentsRepository = rentsRepository;
        this.personRepository = personRepository;
        this.livreRepository = livreRepository;
    }

    public List<Rent> getRents() throws ParseException {
        List<Rent> rentsList = rentsRepository.findAll();
        return rentsList;
    }

    public Rent getRent(@PathVariable(name="id") Long id){
        return rentsRepository.findById(id).get();
    }


    public Iterable<Rent> getReservationByUser(@PathVariable(name="username") String username){
        Person person = personRepository.findByUsername(username);
        return rentsRepository.findByPerson(person);
    }

    public Rent addRent (@PathVariable(name="username") String username, @PathVariable(name="id") Long idLivre, DateDTO dates) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Livre livre = livreRepository.findById(idLivre).get();
        Person person = personRepository.findByUsername(username);
        Date debutLoc = dateFormat.parse(dates.getDebutLocation());
        Date finLoc = dateFormat.parse(dates.getFinLocation());
        Rent reservationAdd = new Rent(debutLoc,finLoc,livre,person);
        livre.setRented(true);
        return rentsRepository.save(reservationAdd);
    }


   /* public Reservation updateReservation (@PathVariable(name="id") Long id,@RequestBody DateDTO dates) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date beginRent = dateFormat.parse(dates.getBeginRent());
        Date endRent = dateFormat.parse(dates.getEndRent());
        Reservation reservation =  this.getReservation(id);
        reservation.setBeginRent(beginRent);
        reservation.setEndRent(endRent);
        return reservationRepository.save(reservation);
    }*/

    /*public void deleteRoom (@PathVariable(name="id") Long id){
        reservationRepository.deleteById(id);
    } */

}
