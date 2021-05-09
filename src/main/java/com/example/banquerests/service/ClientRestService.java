package com.example.banquerests.service;


import com.example.banquerests.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestService {


    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clients" , method = RequestMethod.POST)
    public Client saveClient(@RequestBody Client c) {
        return clientService.saveClient(c);
    }

    @RequestMapping(value = "/clients" , method = RequestMethod.GET)
    public List<Client> listeClients() {
        return clientService.listeClients();
    }

}
