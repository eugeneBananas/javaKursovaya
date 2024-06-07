package ru.mirea.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.dto.request.OrderInfoRequest;
import ru.mirea.edu.model.OrderInfo;

import ru.mirea.edu.service.OrderInfoService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderInfoController {
    @Autowired
    OrderInfoService orderInfoService;

    @GetMapping("/{id}")
    public OrderInfo getOrderOne(@PathVariable("id") int id){
        return orderInfoService.getOrder(id);
    }

    @GetMapping
    public List<OrderInfo> getOrders(){
        return orderInfoService.getAllOrders();
    }

    @PostMapping
    public OrderInfo createOrder(@RequestBody OrderInfoRequest request) {

        OrderInfo newOrderInfo = new OrderInfo();
        newOrderInfo.setClient(orderInfoService.findClient(request.getClientId()));
        newOrderInfo.setServiceType(orderInfoService.findServiceType(request.getServiceTypeId()));
        newOrderInfo.setOrderDate(request.getOrderDate());
        newOrderInfo.setStatus(request.getStatus());
//        newOrderInfo.setTotalCost(request.getTotalCost());
        newOrderInfo.setTotalCost(BigDecimal.ZERO);

        return orderInfoService.createOrder(newOrderInfo);
    }

    @PutMapping("/{id}")
    public OrderInfo updateOrder(@PathVariable("id") int id, @RequestBody OrderInfoRequest request){

        OrderInfo newOrderInfo = new OrderInfo();
        newOrderInfo.setClient(orderInfoService.findClient(request.getClientId()));
        newOrderInfo.setServiceType(orderInfoService.findServiceType(request.getServiceTypeId()));
        newOrderInfo.setOrderDate(request.getOrderDate());
        newOrderInfo.setStatus(request.getStatus());
//        newOrderInfo.setTotalCost(request.getTotalCost());

        return orderInfoService.updateOrder(id, newOrderInfo);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        orderInfoService.deleteOrder(id);
        return "OK";
    }
}
