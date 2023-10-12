package es.apipharmashop.apipharmashop.controllers;


import es.apipharmashop.apipharmashop.models.User;
import es.apipharmashop.apipharmashop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    ResponseEntity<Object> index() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    ResponseEntity<Object> show(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userRepository.findAllById(Collections.singleton(id)), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> create(@RequestBody User user){
        String normalPassword = user.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(normalPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
        return new ResponseEntity<>(user.isPresent(), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody User user){
        Optional<User> oldUser = userRepository.findById(id);
        if (oldUser.isPresent()){
            user.setId(id);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }



}