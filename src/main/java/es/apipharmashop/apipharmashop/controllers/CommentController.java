package es.apipharmashop.apipharmashop.controllers;


import es.apipharmashop.apipharmashop.models.Comment;
import es.apipharmashop.apipharmashop.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    CommentRepository commentRepository;

//Ruta de comentarios
    @GetMapping("/comments")
        ResponseEntity<Object> index() {
            return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
        }

    @GetMapping("/comments/{id}")
    ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commentRepository.findAllById(Collections.singleton(id)), HttpStatus.OK);
    }

    @PostMapping("/comments")
    public ResponseEntity<Object> create(@RequestBody Comment comment){
        commentRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        Optional<Comment> comment = commentRepository.findById(id);
        comment.ifPresent(value -> commentRepository.delete(value));
        return new ResponseEntity<>(comment.isPresent(), HttpStatus.OK);
    }
}
