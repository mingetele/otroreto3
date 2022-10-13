package com.usa.misiontic.masterclass3.controller;


import com.usa.misiontic.masterclass3.entities.Client;
import com.usa.misiontic.masterclass3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId) { return clientService.getClient(clientId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client p){
        return clientService.save(p);
    }
    @PutMapping("/update")
    public Client update(@RequestBody Client p) {return clientService.update(p);}
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int clientId) {
        return clientService.delete(clientId);
    }

}
