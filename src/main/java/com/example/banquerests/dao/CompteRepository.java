package com.example.banquerests.dao;

import com.example.banquerests.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    public Compte findByCodeCompte(String codeCpte);
}
