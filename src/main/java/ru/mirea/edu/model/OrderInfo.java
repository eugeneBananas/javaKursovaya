package ru.mirea.edu.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orderInfo")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "serviceType")
    private ServiceType serviceType;
    @OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "orderInfo", cascade = CascadeType.ALL)
    private List<ItemInfo> ItemInfos;
    private Date orderDate;        // Дата заказа
    private String status;         // Статус заказа
    private BigDecimal totalCost;  // Общая стоимость заказа
//    private List<Item> items;

    public Date getOrderDate() {
        return orderDate;
    }

    public Client getClient() {
        return client;
    }

    public String getStatus() {
        return status;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
////
public void setClient(Client client) {
    this.client = client;
}

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
  ////
    public void updateDetails(OrderInfo updatedOrderInfo) {
        this.client = updatedOrderInfo.getClient();
        this.orderDate = updatedOrderInfo.getOrderDate();
        this.status = updatedOrderInfo.getStatus();
        this.totalCost = updatedOrderInfo.getTotalCost();
    }

}
