package com.example.banquerests.service;

import com.example.banquerests.entities.Client;

import java.util.List;

public interface ClientService {
public Client saveClient(Client c);
public List<Client> listeClients();
}
