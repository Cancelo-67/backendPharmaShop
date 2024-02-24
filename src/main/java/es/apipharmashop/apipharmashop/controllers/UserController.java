package es.apipharmashop.apipharmashop.controllers;


import es.apipharmashop.apipharmashop.models.User;
import es.apipharmashop.apipharmashop.repositories.UserRepository;
import es.apipharmashop.apipharmashop.services.TokenService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
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

    //Pedir token

        private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

        private final TokenService tokenService;

        public UserController(TokenService tokenService) {
            this.tokenService = tokenService;
        }

    @PostMapping("/token")
    public ResponseEntity<String> token(Authentication authentication) {
        try {
            LOG.debug("Token requested for user: '{}'", authentication.getName());
            String token = tokenService.generateToken(authentication);
            LOG.debug("Token granted: {}", token);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            LOG.error("Error generating token:", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating token");
        }
        }
}
