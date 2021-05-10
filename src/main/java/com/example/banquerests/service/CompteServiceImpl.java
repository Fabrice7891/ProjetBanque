package com.example.banquerests.service;

import com.example.banquerests.dao.ClientRepository;
import com.example.banquerests.dao.CompteRepository;
import com.example.banquerests.entities.Client;
import com.example.banquerests.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    @Autowired
    private ClientRepository clientRepository;
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

    @Override
    public Collection<Compte> getCompteClient(Long codeClient) {
        Client clt=clientRepository.findByCodeClient(codeClient);
        if(clt==null) throw new RuntimeException("Client intruvable");
        if(clt.getComptes().size()==0) throw new RuntimeException("Ce client ne possede aucun compte");
        return clt.getComptes();
    }
}
