package com.example.ProjectBibliotheque.controllers;

import com.example.ProjectBibliotheque.model.DateDTO;
import com.example.ProjectBibliotheque.model.Rent;
import com.example.ProjectBibliotheque.service.RentsService;
import org.apache.tomcat.websocket.WsRemoteEndpointBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RentController {

    @Autowired
    private RentsService rentService;

    @GetMapping("/rents")
    public List<Rent> getReservations() throws ParseException {
        return this.rentService.getRents();
    }

    @GetMapping(value="/rents/{username}")
    public Iterable<Rent> getReservationByUser(@PathVariable(name="username") String username){
        return this.rentService.getReservationByUser(username);
    }

    @PostMapping(value="/rents/{username}/{idLivre}")
    public Rent addReservationToUser (@PathVariable(name="username") String username, @PathVariable(name="idLivre") Long idLivre, @RequestBody DateDTO dates) throws ParseException {
        return this.rentService.addRent(username,idLivre ,dates);
    }

}
