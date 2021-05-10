package com.example.banquerests.service;


import com.example.banquerests.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CompteRestService  {


    @Autowired
    private CompteService compteService;

    @RequestMapping(value = "/comptes" , method = RequestMethod.POST)
    public Compte saveCompte(@RequestBody Compte c) {
        return compteService.saveCompte(c);
    }

    @RequestMapping(value = "/comptes/{code}" , method = RequestMethod.GET)
    public Compte getCompte(@PathVariable String code) {
        return compteService.getCompte(code);
    }

    @RequestMapping(value = "/comptesClient/{codeClient}" , method = RequestMethod.GET)
    public Collection<Compte> getCompteClient(@PathVariable Long codeClient) {
        return compteService.getCompteClient(codeClient);
    }



}
