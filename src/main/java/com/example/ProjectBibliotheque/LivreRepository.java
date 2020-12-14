package com.example.ProjectBibliotheque;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivreRepository extends CrudRepository<Livre, String> {

    @Override
    List<Livre> findAll();
    long count();
    Livre save(Livre car);

}
