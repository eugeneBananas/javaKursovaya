package ru.mirea.edu.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoRequest {
    private int clientId; // здесь Long, чтобы можно было передать null, если id неизвестен
    private int serviceTypeId;
    private Date orderDate;
    private String status;
    private BigDecimal totalCost;

    public int getClientId() {
        return clientId;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
}
