package com.example.ProjectBibliotheque;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livre implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<Rent> rents = new ArrayList<Rent>();

    private long id;
    public String titre;
    private int price;
    //  private Dates dates;
    //  private boolean rented;


    public Livre() {
        super();
    }

    public Livre(String titre, int price) {
        super();
        this.titre = titre;
        this.price = price;
        //  this.dates=dates;
        //  this.rented=rented;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
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
    /**
     public Dates getDates() {
     return dates;
     }

     public void setDates(Dates dates) {
     this.dates = dates;
     }

     public boolean isRented() {
     return rented;
     }

     public void setRented(boolean rented) {
     this.rented = rented;
     }
     **/
    @Override
    public String toString() {
        return "Livre{" +
                "id='" + id + '\'' +
                ", titre='" + titre + '\'' +
                ", price=" + price +
                //    ", dates=" + dates +
                //    ", rented=" + rented +
                '}';
    }
}

