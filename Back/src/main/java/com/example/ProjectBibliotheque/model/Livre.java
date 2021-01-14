package com.example.ProjectBibliotheque.model;

import com.example.ProjectBibliotheque.model.Rent;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livre implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Rent> rents = new ArrayList<Rent>();

    @Id
    private long id;
    public String titre;
    public String desc;
    public String auteur;
    private int price;
    public Boolean isRented = false;


    public Livre() {
        super();
    }

    public Livre(String titre, String desc, String auteur ,int price) {
        super();
        this.titre = titre;
        this.price = price;
        this.auteur = auteur;
        this.desc = desc;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @JsonIgnore
    @OneToMany(mappedBy="livre", cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return "Livre{" +
                ", id=" + id +
                ", titre='" + titre + '\'' +
                ", desc='" + desc + '\'' +
                ", auteur='" + auteur + '\'' +
                ", price=" + price +
                '}';
    }
}

