package ru.mirea.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.edu.model.Comment;
import ru.mirea.edu.model.OrderInfo;
import ru.mirea.edu.repository.CommentRepository;
import ru.mirea.edu.repository.OrderInfoRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    OrderInfoRepository orderInfoRepository;

    public OrderInfo findOrder(int id){
        return orderInfoRepository.findById(id).orElseThrow();
    }

    public Comment createComment(Comment comment){
        commentRepository.save(comment);
        return comment;
    }

    public Comment updateComment(int id, Comment comment){
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new Error("Комментарий не найден с id: " + id));

        // Обновляем поля существующего клиента
        existingComment.updateDetails(comment);

        // Сохраняем обновленного клиента
        return commentRepository.save(existingComment);
    }

    public Comment getComment(int Id){
        return commentRepository.findById(Id).orElseThrow(() -> new NoSuchElementException("Комментарий с Id " + Id + " не найден"));
    };

    public List<Comment> getAllComments(){
        return commentRepository.findAll();
    };

    public void deleteComment(int id){
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Комментарий не найден с id: " + id));

        commentRepository.delete(existingComment);
    }
}
