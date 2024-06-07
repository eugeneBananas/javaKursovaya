package ru.mirea.edu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.edu.model.ItemInfo;
import ru.mirea.edu.model.OrderInfo;
import ru.mirea.edu.repository.ItemInfoRepository;
import ru.mirea.edu.repository.OrderInfoRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ItemInfoService {
    @Autowired
    ItemInfoRepository itemInfoRepository;
    @Autowired
    OrderInfoRepository orderInfoRepository;

    public OrderInfo findOrder(int id){
        return orderInfoRepository.findById(id).orElseThrow();
    }

    public ItemInfo createItemInfo(ItemInfo itemInfo){
        BigDecimal newCost = itemInfo.getCost().add(itemInfo.getOrderInfo().getTotalCost());
        itemInfoRepository.save(itemInfo);

        OrderInfo newOrderInfo = itemInfo.getOrderInfo();
        newOrderInfo.setTotalCost(newCost);
        orderInfoRepository.save(newOrderInfo);

        return itemInfo;
    }

    public ItemInfo updateItemInfo(int id, ItemInfo itemInfo){
        ItemInfo existingItemInfo = itemInfoRepository.findById(id)
                .orElseThrow(() -> new Error("Вещь не найдена с id: " + id));

        BigDecimal newCost = itemInfo.getCost().add(itemInfo.getOrderInfo().getTotalCost()).subtract(existingItemInfo.getCost());

        // Обновляем поля существующего клиента
        existingItemInfo.updateDetails(itemInfo);

        OrderInfo newOrderInfo = itemInfo.getOrderInfo();
        newOrderInfo.setTotalCost(newCost);
        orderInfoRepository.save(newOrderInfo);


        // Сохраняем обновленного клиента
        return itemInfoRepository.save(existingItemInfo);
    }
    //    public int deleteClient(int Id);
    public ItemInfo getItemInfo(int Id){
        return itemInfoRepository.findById(Id).orElseThrow(() -> new NoSuchElementException("Вещь с Id " + Id + " не найден"));
    };

    public List<ItemInfo> getAllItemInfos(){
        return itemInfoRepository.findAll();
    };

    public void deleteItemInfo(int id){
        ItemInfo existingItemInfo = itemInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вещь не найдена с id: " + id));

        BigDecimal newCost = existingItemInfo.getOrderInfo().getTotalCost().subtract(existingItemInfo.getCost());

        OrderInfo newOrderInfo = existingItemInfo.getOrderInfo();
        newOrderInfo.setTotalCost(newCost);
        orderInfoRepository.save(newOrderInfo);

        itemInfoRepository.delete(existingItemInfo);
    }
}
