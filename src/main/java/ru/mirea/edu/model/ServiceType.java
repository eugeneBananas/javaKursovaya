package ru.mirea.edu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "serviceType")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "serviceType", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderInfo> orderInfos;
    private String name;           // Название услуги
    private String description;    // Описание услуги

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public void updateDetails(ServiceType updatedServiceType) {
        this.name = updatedServiceType.getName();
        this.description = updatedServiceType.getDescription();
    }

}