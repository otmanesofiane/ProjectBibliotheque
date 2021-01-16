package com.example.ProjectBibliotheque.repository;

import com.example.ProjectBibliotheque.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {

    List<Livre> findAll();
    long count();
    void delete(Livre livre);

}
