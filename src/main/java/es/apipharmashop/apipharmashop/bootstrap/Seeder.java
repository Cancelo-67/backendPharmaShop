package es.apipharmashop.apipharmashop.bootstrap;


import es.apipharmashop.apipharmashop.models.Order;
import es.apipharmashop.apipharmashop.models.Product;
import es.apipharmashop.apipharmashop.models.User;
import es.apipharmashop.apipharmashop.repositories.OrderRepository;
import es.apipharmashop.apipharmashop.repositories.ProductRepository;
import es.apipharmashop.apipharmashop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class Seeder implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public Seeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        //Users
        User user1 = new User("alejandro", "cancelo", true, "652671034", "alejandro67@gmail.com", "contraseñaprueba", "key1", "Calle prueba1", "1");
        userRepository.save(user1);
        User user2 = new User("gonzalo", "pulido", true, "652671033", "gonzalo@gmail.com", "contraseñaprueba", "key1", "Calle prueba1", "1");
        userRepository.save(user2);

        //Orders
        Date currentDate = new Date();
        Random random = new Random();
        long randomTime = currentDate.getTime() + TimeUnit.DAYS.toMillis(random.nextInt(30));
        Date orderDate = new Date(randomTime);
        Order order1 = new Order();
        order1.setDate(orderDate);
        orderRepository.save(order1);

        //Products
        Product product1 = new Product("image","ibuprofeno", 10, "description", 2024);
        productRepository.save(product1);

        Product product2 = new Product("image", "Espidifen", 5, "descripcion", 2025);
        productRepository.save(product2);
    }
}