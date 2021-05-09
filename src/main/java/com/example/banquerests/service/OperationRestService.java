package com.example.banquerests.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {

    @Autowired
    private  OperationService operationService;

    @RequestMapping(value = "/versement",method = RequestMethod.PUT)
    public boolean verser(@RequestParam String codeCpte,@RequestParam double montant,@RequestParam Long codeEmp) {
        return operationService.verser(codeCpte, montant, codeEmp);
    }

    @RequestMapping(value = "/retrait",method = RequestMethod.PUT)
    public boolean retirer(@RequestParam String codeCpte,@RequestParam double montant,@RequestParam Long codeEmp) {
        return operationService.retirer(codeCpte, montant, codeEmp);
    }

    @RequestMapping(value = "/virement",method = RequestMethod.PUT)
    public boolean virement(@RequestParam String codeCpte1 ,@RequestParam String codeCpte2,@RequestParam double montant,@RequestParam Long codeEmp) {
        return operationService.virement(codeCpte1, codeCpte2, montant, codeEmp);
    }



}
