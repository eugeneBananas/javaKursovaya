package ru.mirea.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.model.Client;
import ru.mirea.edu.model.OrderInfo;
import ru.mirea.edu.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{id}")
    public Client getClientOne(@PathVariable("id") int id){
        return clientService.getClient(id);
    }

    @GetMapping("/orders/{id}")
    public List<OrderInfo> giveOrderInfos(@PathVariable("id") int id){
        return clientService.giveOrderInfos(id);
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getAllClients();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") int id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable("id") int id){
        clientService.deleteClient(id);
        return "OK";
    }
}
