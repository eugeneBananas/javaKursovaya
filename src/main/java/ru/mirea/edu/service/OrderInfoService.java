package ru.mirea.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.edu.model.Client;
import ru.mirea.edu.model.OrderInfo;
import ru.mirea.edu.model.ServiceType;
import ru.mirea.edu.repository.ClientRepository;
import ru.mirea.edu.repository.OrderInfoRepository;
import ru.mirea.edu.repository.ServiceTypeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderInfoService {
    @Autowired
    OrderInfoRepository orderInfoRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ServiceTypeRepository serviceTypeRepository;

    public OrderInfo createOrder(OrderInfo orderInfo){
        orderInfoRepository.save(orderInfo);
        return orderInfo;
    }

    public Client findClient(int id){
        return clientRepository.findById(id).orElseThrow();
    }

    public ServiceType findServiceType(int id){
        return serviceTypeRepository.findById(id).orElseThrow();
    }

    public OrderInfo updateOrder(int id, OrderInfo orderInfo){
        OrderInfo existingOrderInfo = orderInfoRepository.findById(id)
                .orElseThrow(() -> new Error("Заказ не найден с id: " + id));

        // Обновляем поля существующего клиента
        existingOrderInfo.updateDetails(orderInfo);

        // Сохраняем обновленного клиента
        return orderInfoRepository.save(existingOrderInfo);
    }
    //    public int deleteOrder(int Id);
    public OrderInfo getOrder(int Id){
        return orderInfoRepository.findById(Id).orElseThrow(() -> new NoSuchElementException("Заказ с Id " + Id + " не найден"));
    };

    public List<OrderInfo> getAllOrders(){
        return orderInfoRepository.findAll();
    };

    public void deleteOrder(int id){
        OrderInfo existingOrderInfo = orderInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Заказ не найден с id: " + id));

        orderInfoRepository.delete(existingOrderInfo);
    }
}
