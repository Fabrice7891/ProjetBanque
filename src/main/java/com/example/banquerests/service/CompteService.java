package com.example.banquerests.service;

import com.example.banquerests.entities.Compte;

import java.util.Collection;
import java.util.List;

public interface CompteService {
    public Compte saveCompte(Compte c);
    public Compte getCompte(String code);

    // Retourne les compte d un client donné
    public Collection<Compte> getCompteClient(Long codeClient);
}
