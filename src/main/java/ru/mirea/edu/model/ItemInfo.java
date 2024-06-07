package ru.mirea.edu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemInfo {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "orderInfo")
    private OrderInfo orderInfo;
    private String name;           // Название предмета
//    private Integer quantity;      // Количество
    private BigDecimal cost;       // Стоимость
    private String description;    // Описание

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void updateDetails(ItemInfo updatedItemInfo) {
        this.name = updatedItemInfo.getName();
        this.cost = updatedItemInfo.getCost();
        this.description = updatedItemInfo.getDescription();
    }

}