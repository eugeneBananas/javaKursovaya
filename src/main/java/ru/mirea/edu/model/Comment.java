package ru.mirea.edu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "comment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "orderInfo")
    private OrderInfo orderInfo;       // Идентификатор заказа, к которому относится комментарий
    private String text;           // Текст комментария
    private Date timestamp;        // Дата и время комментария

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setOrder(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public void updateDetails(Comment updatedComment) {
        this.text = updatedComment.getText();
        this.timestamp = updatedComment.getTimestamp();
    }

}
