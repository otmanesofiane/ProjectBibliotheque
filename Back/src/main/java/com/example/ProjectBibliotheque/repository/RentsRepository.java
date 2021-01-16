package com.example.ProjectBibliotheque.repository;

import com.example.ProjectBibliotheque.model.Person;
import com.example.ProjectBibliotheque.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentsRepository extends JpaRepository<Rent, Long> {
    List<Rent> findAll();
    List<Rent> findByPerson(Person person);
    Rent save(Rent reservation);

}
