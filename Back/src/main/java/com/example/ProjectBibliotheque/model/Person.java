package com.example.ProjectBibliotheque.model;



import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

public class Person {
    @Id
    private long idUser;
    @Column(unique=true)
    private String username;
    private String password;
    private Role role;


    public Person() {
        super();
    }


    public Person(String username, String password, Role role) {
        super();
        this.username = username;
        this.password = password;
        this.role=role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToOne
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
