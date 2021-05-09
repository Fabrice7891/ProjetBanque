package com.example.banquerests.service;

import com.example.banquerests.entities.Compte;

public interface CompteService {
    public Compte saveCompte(Compte c);
    public Compte getCompte(String code);
}
