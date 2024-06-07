package ru.mirea.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.dto.request.CommentRequest;
import ru.mirea.edu.dto.request.ItemInfoRequest;
import ru.mirea.edu.model.Comment;
import ru.mirea.edu.model.ItemInfo;
import ru.mirea.edu.service.ItemInfoService;

import java.util.List;

@RestController
@RequestMapping("/itemInfo")
public class ItemInfoController {
    @Autowired
    ItemInfoService itemInfoService;

    @GetMapping("/{id}")
    public ItemInfo getItemInfoOne(@PathVariable("id") int id){
        return itemInfoService.getItemInfo(id);
    }

    @GetMapping
    public List<ItemInfo> getItemInfos(){
        return itemInfoService.getAllItemInfos();
    }

    @PostMapping
    public ItemInfo createItemInfo(@RequestBody ItemInfoRequest request) {

        ItemInfo newItemInfo = new ItemInfo();
        newItemInfo.setOrderInfo(itemInfoService.findOrder(request.getOrderId()));
        newItemInfo.setName(request.getName());
//        newItemInfo.setQuantity(request.getQuantity());
        newItemInfo.setCost(request.getCost());
        newItemInfo.setDescription(request.getDescription());

        return itemInfoService.createItemInfo(newItemInfo);
    }

    @PutMapping("/{id}")
    public ItemInfo updateItemInfo(@PathVariable("id") int id, @RequestBody ItemInfoRequest request) {

        ItemInfo newItemInfo = new ItemInfo();
        newItemInfo.setOrderInfo(itemInfoService.findOrder(request.getOrderId()));
        newItemInfo.setName(request.getName());
        newItemInfo.setCost(request.getCost());
        newItemInfo.setDescription(request.getDescription());

        return itemInfoService.updateItemInfo(id, newItemInfo);
    }

    @DeleteMapping("/{id}")
    public String deleteItemInfo(@PathVariable("id") int id){
        itemInfoService.deleteItemInfo(id);
        return "OK";
    }
}
