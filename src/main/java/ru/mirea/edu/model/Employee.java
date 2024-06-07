//package ru.mirea.edu.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import lombok.*;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Entity
//@Table(name = "_user")
//@Getter
//@Setter
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class Employee {
//    @Id
//    @GeneratedValue
//    private Integer id;
//    private String name;      // Имя
//    private String position;       // Должность
//    private String contactInfo;    // Контактная информация
//
//    public void updateDetails(Client updatedClient) {
//        this.email = updatedClient.getEmail();
//        this.password = updatedClient.getPassword();
//        this.name = updatedClient.getName();
//        this.phoneNumber = updatedClient.getPhoneNumber();
//    }
//
//}
