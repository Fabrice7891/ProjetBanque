package com.example.banquerests.service;

import com.example.banquerests.entities.Employe;

import java.util.List;

public interface EmployeService {
    public Employe saveEmploye(Employe e);
    public List<Employe> consulterEmploye();
}
