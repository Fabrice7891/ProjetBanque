package com.example.banquerests.service;

import com.example.banquerests.dao.CompteRepository;
import com.example.banquerests.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {
    @Autowired
    private CompteRepository compteRepository;

    @Override
    public Compte saveCompte(Compte c) {
        c.setDateCreation(new Date());
        return compteRepository.save(c);
    }

    @Override
    public Compte getCompte(String code) {
        return compteRepository.findByCodeCompte(code);
    }
}
