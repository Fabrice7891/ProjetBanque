package com.example.banquerests.service;

import com.example.banquerests.dao.EmployeRepository;
import com.example.banquerests.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;


@RestController
public class EmployeRestService {

    @Autowired
    private EmployeService  employeRepository;

    @RequestMapping(value = "/employes" , method = RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe e) {
        return employeRepository.saveEmploye(e);
    }

    @RequestMapping(value = "/employes" , method = RequestMethod.GET)
    public List<Employe> consulterEmploye() {
        return employeRepository.consulterEmploye();
    }
}
