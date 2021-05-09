package com.example.banquerests.service;

import com.example.banquerests.entities.Operation;

import java.util.List;

public interface OperationService {
    public boolean verser(String  codeCpte, double montant, Long codeEmp );
    public boolean retirer(String codeCpte, double montant, Long codeEmp);
    public boolean virement(String cpte1, String cpte2, double montant , Long codeEmp);
    public List<Operation> listeOperation();
}
