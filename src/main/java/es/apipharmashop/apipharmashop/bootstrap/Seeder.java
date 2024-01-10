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

import java.util.*;
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
        User user1 = new User(   "Alejandro", "Cancelo", "Hombre",User.Role.ADMIN, "652671034", "alecanjerez67@gmail.com", "pruebacontraseña123","C/Prueba", "", Collections.emptyList(), orders);
        userRepository.save(user1);
        User user2 = new User("Gonzalo", "Pulido", "Hombre",User.Role.USER, "652671034", "gon07ps@gmail.com", "prueba123", "C/Prueba","", Collections.emptyList(), orders);
        userRepository.save(user2);
        User user3 = new User("Natalia", "Mujer","Rodriguez", User.Role.ADMIN, "678015612", "natalia@gmail.com", "nataliaprueba123", "C/Canaria","", Collections.emptyList(), orders);
        userRepository.save(user3);


        //Products
        Product product1 = new Product("https://www.pharmashop.es/20610-home_default/lacer-pasta-con-fluor-75-ml.jpg","Lacer pasta con fluor","Dental", 10, "description", 5, "resumen");
        productRepository.save(product1);

        Product product2 = new Product("https://www.pharmashop.es/19833-home_default/agua-de-belleza-100ml.jpg", "Agua de belleza","Cosmetica", 5, "descripcion", 9, "resumen");
        productRepository.save(product2);

        Product product3 = new Product("https://www.pharmashop.es/14243-home_default/hermesetas-original-1200-comp.jpg", "Hermesetas","Nutricion", 5, "descripcion", 30, "resumen");
        productRepository.save(product3);

        Product product4 = new Product("https://www.pharmashop.es/12578-home_default/goah-clinic-siluit-60-capsulas.jpg", "Goah clinic siluit","Higiene", 5, "descripcion", 20, "resumen");
        productRepository.save(product4);

        Product product5 = new Product("https://www.pharmashop.es/14052-home_default/adiprox-advanced-50-capsulas.jpg", "Adiprox advanced","Mascotas", 5, "descripcion", 17, "resumen");
        productRepository.save(product5);
        Product product6 = new Product("https://www.pharmashop.es/19344-home_default/lynfase-concentrado-fluido-monodosis-12-frascos.jpg", "Lynfase Concentrado Fluido Monodosis","Dental", 5, "descripcion", 14, "resumen");
        productRepository.save(product6);
        Product product7 = new Product("https://www.pharmashop.es/19345-home_default/lynfase-tisana-bolsitas-filtro-20-filtros.jpg", "Lynfase Concentrado Fluido Monodosis","Bebe y mama", 5, "descripcion", 10, "resumen");
        productRepository.save(product7);
        Product product8 = new Product("https://www.pharmashop.es/21744-big_default/vitis-enjuague-bucal-aloe-vera-1-l.jpg", "Vitis Enjuage Bucal Aloe Veras 1L","Dental", 9.55, "Nuestro Vitis Colutorio 1000 ml es un enjuague bucal que te puede ayudar a reducir la placa bacteriana. Esta, a su vez, es la causa más importante de la aparición de la gingivitis que, de paso, también podría ser evitada mediante este producto. Además, puedes usar el Colutorio Vitis todos los días, porque no irritará tus encías y te brinda un exquisito sabor.", 26, "resumen");
        productRepository.save(product8);
        Product product9 = new Product("https://www.pharmashop.es/24159-big_default/gingilacer-colutorio-500-ml.jpg", "Lacer Gingilacer Colutorio Para Encias Sensibles","Dental", 9.95, "Colutorio Lacer Gingilacer es un artículo higiénico de alta calidad diseñado para aliviar el sangrado y la sensación de incomodidad en las encías durante y después del cepillado. Cuenta con una fórmula especial que refuerza la estructura gingival a través del aporte de nutrientes minerales. Además, reduce la inflamación y regenera las capas superficiales del tejido sensible en encías pequeñas.", 24, "resumen");
        productRepository.save(product9);
        Product product10 = new Product("https://www.pharmashop.es/12560-big_default/oraldine-colutorio-antiseptico-pack-400-ml-200-ml.jpg", "Oraldine Antiseptico Pack 400ML + 200ML","Dental", 5.54, "Colutorio Oraldine antiséptico, para una limpieza profunda.", 19, "resumen");
        productRepository.save(product10);
        Product product11 = new Product("https://www.pharmashop.es/12877-big_default/parodontax-colutorio-uso-diario-500-ml.jpg", "Paradontax Colutorio Uso Diario 500 ML","Dental", 6.19, "Parodontax Colutorio de uso diario de 500ml", 16, "resumen");
        productRepository.save(product11);
        Product product12 = new Product("https://www.pharmashop.es/12877-big_default/parodontax-colutorio-uso-diario-500-ml.jpg", "Paradontax Colutorio Uso Diario 500 ML","Dental", 6.19, "Parodontax Colutorio de uso diario de 500ml", 15,"resumen");
        productRepository.save(product12);
        Product product13 = new Product("https://www.pharmashop.es/12877-big_default/parodontax-colutorio-uso-diario-500-ml.jpg", "Paradontax Colutorio Uso Diario 500 ML","Dental", 6.19, "Parodontax Colutorio de uso diario de 500ml", 10, "resumen");
        productRepository.save(product13);
        Product product14 = new Product("https://www.pharmashop.es/18260-big_default/navitae-plus-gotas-oftalmicas-15-ml.jpg", "Navitae Plus Gotas Oftalmicas 15ml","Optica", 9.39, "Navitae Plus Gotas Oftálmicas, protege, restaura y alivia la superficie ocular dañada por agentes externos.", 10, "Navitae Plus es una solución oftálmica que actúa como lubricante ocular que gracias a su composición proporciona alivio a los ojos irritados, secos , molestias por el uso de lentes de contacto, cirugías, etc.Esta compuesto por Hialuronato Sódico y Carboximetil Beta-Glucano que ejercen acción lubricante y la acción de la Vitamina E y A como lubricantes protectores.\n" +
                "La Vitamina A mejora el uso de las lentillas reduciendo los daños de fricción y además estabiliza la fase oleosa del film lacrimal, ayudando a mantener la hidratación natural del ojo y redución los síntomas de sequedad ocular.\n" +
                "La Vitamina E aporta su acción antioxidante reduciendo la concentración de radicales libres en el fluido lacrimal. Por lo que se protegen la córnea y la conjuntiva disminuyendo el riesgo de inflamación y ayudando a los procesos de curación en caso de post operatorio.\n" +
                "Navitae Plus es compatible con el uso de cualquier tipo de lente de contacto.\n" +
                " \n" +
                "Este producto esta indicado para alivio del ojo seco y el malestar causado por:\n" +
                "\n" +
                "Irirtación ocular debida a patologías como queratitis, reacciones abversas a cirugia ocular, infamación...\n" +
                "Estrés oxidativo por exposición a la luz y/o incremento de los radicales libres en la superficie ocular.\n" +
                "Uso de lentes de contacto.\n" +
                "\n" +
                "Modo de empleo:\n" +
                "\n" +
                "Lave , aclare y seque sus manos cuidadosamente.\n" +
                "Asegúrese de que el precinto del producto está intacto. Para abrir la botella, desenrosque completamente el tapón y rompa el precinto.\n" +
                "Instile 1 ó 2 gotas en cada ojo, 3 a 6 veces al día o según indique el especialista.\n" +
                "Cierre bien la botella después de su uso.\n");
        productRepository.save(product14);
    }
}