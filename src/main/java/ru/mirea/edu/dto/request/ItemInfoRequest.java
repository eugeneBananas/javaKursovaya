package ru.mirea.edu.dto.request;

import java.math.BigDecimal;

public class ItemInfoRequest {
    private Integer orderId;
    private String name;
    private Integer quantity;      // Количество
    private BigDecimal cost;       // Стоимость
    private String description;

    public String getName() {
        return name;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

}
