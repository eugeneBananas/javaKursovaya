package ru.mirea.edu.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    private Integer orderId; // Идентификатор заказа, к которому относится комментарий
    private String text;           // Текст комментария
    private Date timestamp;        // Дата и время комментария
    private String author;

    public Integer getOrderId() {
        return orderId;
    }

    public String getText() {
        return text;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getAuthor() {
        return author;
    }
}
