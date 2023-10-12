package es.apipharmashop.apipharmashop.controllers;

import es.apipharmashop.apipharmashop.models.Order;
import es.apipharmashop.apipharmashop.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;


@RestController
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    @GetMapping("/orders")
    ResponseEntity<Object> index() {
        return new ResponseEntity<>(orderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderRepository.findAllById(Collections.singleton(id)), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<Object> create(@RequestBody Order order){
        orderRepository.save(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(value -> orderRepository.delete(value));
        return new ResponseEntity<>(order.isPresent(), HttpStatus.OK);
    }


}
