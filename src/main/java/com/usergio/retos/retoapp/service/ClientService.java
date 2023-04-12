package com.usergio.retos.retoapp.service;

import com.usergio.retos.retoapp.modelo.entidad.Client;
import com.usergio.retos.retoapp.modelo.repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client save(Client client) {
        return repository.save(client);
    }
}
