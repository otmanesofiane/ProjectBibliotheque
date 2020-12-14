package com.example.ProjectBibliotheque;

import javax.persistence.*;

@Entity
public class Rent {

    private long id;
    public String debutLocation;
    public String finLocation;
    private Livre livre;
    private Personne personne;

    public Rent() {

    }

    public Rent(String debutLocation, String finLocation, Livre livre, Personne personne) {

        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
        this.livre = livre;
        this.personne = personne;

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
    public Personne getPersonne() {
        return personne;
    }

    public void setId(long id) {
        this.id = id;
    }
    /**
     public Dates getDebutLocation() {
     return debutLocation;
     }**/


    public String getDebutLocation() {
        return debutLocation;
    }

    public void setDebutLocation(String debutLocation) {
        this.debutLocation = debutLocation;
    }

    public String getFinLocation() {
        return finLocation;
    }

    public void setFinLocation(String finLocation) {
        this.finLocation = finLocation;
    }

    /**
     public Dates getFinLocation() {
     return finLocation;
     }**/





    public void setLivre(Livre livre) {
        this.livre = livre;
    }


    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}