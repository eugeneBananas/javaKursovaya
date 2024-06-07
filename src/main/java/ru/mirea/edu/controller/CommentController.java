package ru.mirea.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.edu.dto.request.CommentRequest;
import ru.mirea.edu.model.Comment;
import ru.mirea.edu.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService commentService;

    @GetMapping("/{id}")
    public Comment getCommentOne(@PathVariable("id") int id){
        return commentService.getComment(id);
    }

    @GetMapping
    public List<Comment> getComments(){
        return commentService.getAllComments();
    }

    @PostMapping
    public Comment createComment(@RequestBody CommentRequest request) {

        Comment newComment = new Comment();
        newComment.setOrder(commentService.findOrder(request.getOrderId()));
        newComment.setText(request.getText());
        newComment.setTimestamp(request.getTimestamp());

        return commentService.createComment(newComment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable("id") int id, @RequestBody CommentRequest request){

        Comment newComment = new Comment();
        newComment.setOrder(commentService.findOrder(request.getOrderId()));
        newComment.setText(request.getText());
        newComment.setTimestamp(request.getTimestamp());
        return commentService.updateComment(id, newComment);
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable("id") int id){
        commentService.deleteComment(id);
        return "OK";
    }
}
