package com.example.ProjectBibliotheque.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Rent {

    private long id;
    public Date debutLocation;
    public Date finLocation;
    private Livre livre;
    private Person person;

    public Rent() { super();}

    public Rent(Date debutLocation, Date finLocation, Livre livre, Person person) {
        super();
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
        this.livre = livre;
        this.person = person;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    @ManyToOne
    public Livre getLivre() {
        return livre;
    }
    @ManyToOne
    public Person getPerson() {
        return person;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDebutLocation() {
        return debutLocation;
    }

    public void setDebutLocation(Date debutLocation) {
        this.debutLocation = debutLocation;
    }

    public Date getFinLocation() {
        return finLocation;
    }

    public void setFinLocation(Date finLocation) {
        this.finLocation = finLocation;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }


    public void setPerson(Person person) {
        this.person = person;
    }
}