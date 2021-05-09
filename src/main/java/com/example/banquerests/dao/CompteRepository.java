package com.example.banquerests.dao;

import com.example.banquerests.entities.Compte;
import com.example.banquerests.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

//@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {
    public Compte findByCodeCompte(String codeCpte);
    //public List<Operation> findBy
}
