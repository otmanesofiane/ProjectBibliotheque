package com.example.ProjectBibliotheque;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Personne {

    private List<Rent> rent = new ArrayList<Rent>();

    private long id;
    public String name;

    public Personne(){
    }

    public Personne(String name){

        this.id=id;
        this.name=name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @OneToMany(mappedBy="personne", cascade=CascadeType.MERGE, fetch = FetchType.EAGER)
    public List<Rent> getRent() {
        return rent;
    }

    public void setRent(List<Rent> rent) {
        this.rent = rent;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}