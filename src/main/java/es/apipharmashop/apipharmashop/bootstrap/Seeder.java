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
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
        //Orders
        Date currentDate = new Date();
        Random random = new Random();
        long randomTime = currentDate.getTime() + TimeUnit.DAYS.toMillis(random.nextInt(30));
        Date orderDate = new Date(randomTime);
        Order order1 = new Order();
        order1.setDate(orderDate);
        orderRepository.save(order1);
        Set<Order> orders = new HashSet<>();

        //Users
        User user1 = new User("Alejandro", "Cancelo", User.Role.ADMIN, "652671034", "alecanjerez67@gmail.com", "pruebacontraseña123", "C/Prueba", "1", orders);
        userRepository.save(user1);
        User user2 = new User("Gonzalo", "Pulido", User.Role.USER, "652671034", "gon07ps@gmail.com", "prueba123", "C/Prueba", "1", orders);
        userRepository.save(user2);
        User user3 = new User("Natalia", "Rodriguez", User.Role.ADMIN, "678015612", "natalia@gmail.com", "nataliaprueba123", "C/Canaria", "1", orders);
        userRepository.save(user3);


        //Products
        Product product1 = new Product("https://www.pharmashop.es/20610-home_default/lacer-pasta-con-fluor-75-ml.jpg","Lacer pasta con fluor","Dental", 10, "description");
        productRepository.save(product1);

        Product product2 = new Product("https://www.pharmashop.es/19833-home_default/agua-de-belleza-100ml.jpg", "Agua de belleza","Cosmetica", 5, "descripcion");
        productRepository.save(product2);

        Product product3 = new Product("https://www.pharmashop.es/14243-home_default/hermesetas-original-1200-comp.jpg", "Hermesetas","Nutricion", 5, "descripcion");
        productRepository.save(product3);

        Product product4 = new Product("https://www.pharmashop.es/12578-home_default/goah-clinic-siluit-60-capsulas.jpg", "Goah clinic siluit","Higiene", 5, "descripcion");
        productRepository.save(product4);

        Product product5 = new Product("https://www.pharmashop.es/14052-home_default/adiprox-advanced-50-capsulas.jpg", "Adiprox advanced","Mascotas", 5, "descripcion");
        productRepository.save(product5);
        Product product6 = new Product("https://www.pharmashop.es/19344-home_default/lynfase-concentrado-fluido-monodosis-12-frascos.jpg", "Lynfase concentrado fluido monodosis","Dental", 5, "descripcion");
        productRepository.save(product6);
        Product product7 = new Product("https://www.pharmashop.es/19345-home_default/lynfase-tisana-bolsitas-filtro-20-filtros.jpg", "Lynfase concentrado fluido monodosis","Bebe y mama", 5, "descripcion");
        productRepository.save(product7);
    }
}