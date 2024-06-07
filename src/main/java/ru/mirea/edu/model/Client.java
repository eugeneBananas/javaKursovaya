package ru.mirea.edu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderInfo> orderInfos;
    private String email;
    private String password;
    private String name;
    private String phoneNumber;

    public List<OrderInfo> getOrderInfos() {
        return orderInfos;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void updateDetails(Client updatedClient) {
        this.email = updatedClient.getEmail();
        this.password = updatedClient.getPassword();
        this.name = updatedClient.getName();
        this.phoneNumber = updatedClient.getPhoneNumber();
    }

}