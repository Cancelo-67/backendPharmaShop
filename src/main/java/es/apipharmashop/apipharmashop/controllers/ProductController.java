package es.apipharmashop.apipharmashop.controllers;

import es.apipharmashop.apipharmashop.models.Product;
import es.apipharmashop.apipharmashop.models.User;
import es.apipharmashop.apipharmashop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;


    @GetMapping("/products")
    ResponseEntity<Object> index(){ return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);}


    @GetMapping(value = "/products/{id}", params = "id")
    ResponseEntity<Object> showById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productRepository.findAllById(Collections.singleton(id)), HttpStatus.OK);
    }

    @GetMapping("/products/{category}")
    public ResponseEntity<Object> showByCategory(@PathVariable("category") String category) {
        List<Product> products = productRepository.findByCategory(category);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Object> create(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Product product){
        Optional<Product> oldProduct = productRepository.findById(id);
        if (oldProduct.isPresent()){
            product.setId(id);
            productRepository.save(product);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id")Long id){
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(value -> productRepository.delete(value));
        return new ResponseEntity<>(product.isPresent(), HttpStatus.OK);
    }
}
