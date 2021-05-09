package com.example.banquerests.service;

public interface OperationService {
    public boolean verser(String  codeCpte, double montant, Long codeEmp );
    public boolean retirer(String codeCpte, double montant, Long codeEmp);
    public boolean virement(String cpte1, String cpte2, double montant , Long codeEmp);
}
