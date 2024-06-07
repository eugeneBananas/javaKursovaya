package ru.mirea.edu.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.mirea.edu.model.Client;

import java.math.BigDecimal;
import java.util.Date;

public class OrderResponse {
    @JsonIgnore
    private Client client; // здесь Long, чтобы можно было передать null, если id неизвестен
    private Date orderDate;
    private String status;
    private BigDecimal totalCost;
}
