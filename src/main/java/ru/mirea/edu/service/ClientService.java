package ru.mirea.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.edu.model.Client;
import ru.mirea.edu.model.OrderInfo;
import ru.mirea.edu.repository.ClientRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client createClient(Client client){
        clientRepository.save(client);
        return client;
    }

    public List<OrderInfo> giveOrderInfos(int id){
        Client newClient = clientRepository.findById(id).orElseThrow();
        return newClient.getOrderInfos();
    }

    public Client updateClient(int id, Client client){
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new Error("Клиент не найден с id: " + id));

        // Обновляем поля существующего клиента
        existingClient.updateDetails(client);

        // Сохраняем обновленного клиента
        return clientRepository.save(existingClient);
    }
//    public int deleteClient(int Id);
    public Client getClient(int Id){
        return clientRepository.findById(Id).orElseThrow(() -> new NoSuchElementException("Клиент с Id " + Id + " не найден"));
    };

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    };

    public void deleteClient(int id){
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Клиент не найден с id: " + id));

        clientRepository.delete(existingClient);
    }
}
