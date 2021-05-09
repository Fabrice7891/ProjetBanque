package com.example.banquerests.service;

import com.example.banquerests.dao.CompteRepository;
import com.example.banquerests.dao.EmployeRepository;
import com.example.banquerests.dao.OperationRepository;
import com.example.banquerests.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OperationServiceImpl implements OperationService {


    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;

    @Autowired
    private EmployeRepository employeRepository;


    @Override
    public boolean verser(String codeCpte, double montant, Long codeEmp) {
         Compte cp=compteRepository.findByCodeCompte(codeCpte);
         Employe emp= employeRepository.findBycodeEmploye(codeEmp);
         Operation op= new Versement();
         op.setDateOperation(new Date());
         op.setMontant(montant);
         op.setCompte(cp);
         op.setEmploye(emp);
         operationRepository.save(op);
         cp.setSolde(cp.getSolde()+montant);
        return true;
    }

    @Override
    public boolean retirer(String codeCpte, double montant, Long codeEmp) {
        Compte cp=compteRepository.findByCodeCompte(codeCpte);
        if(cp.getSolde()<montant) throw new RuntimeException("Solde Insuffisant");
        Employe emp= employeRepository.findBycodeEmploye(codeEmp);
        Operation op= new Retrait();
        op.setDateOperation(new Date());
        op.setMontant(montant);
        op.setCompte(cp);
        op.setEmploye(emp);
        operationRepository.save(op);
        cp.setSolde(cp.getSolde()-montant);
        return true;
    }

    @Override
    public boolean virement(String cpte1, String cpte2, double montant, Long codeEmp) {
        retirer(cpte1, montant, codeEmp);
        verser(cpte2, montant, codeEmp);
        return true;
    }

    @Override
    public List<Operation> listeOperation() {
        return operationRepository.findAll();
    }
}
