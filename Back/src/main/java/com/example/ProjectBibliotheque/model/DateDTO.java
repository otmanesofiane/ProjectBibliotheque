package com.example.ProjectBibliotheque.model;

public class DateDTO {

    private String debutLocation;
    private String finLocation;

    public DateDTO (String debutLocation, String finLocation){
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
    }

    public String getDebutLocation() {
        return debutLocation;
    }

    public void setDebutLocation(String debutLocation) {
        this.debutLocation = debutLocation;
    }

    public String getFinLocation() {
        return finLocation;
    }

    public void setFinLocation(String endRent) {
        this.finLocation = endRent;
    }
}

