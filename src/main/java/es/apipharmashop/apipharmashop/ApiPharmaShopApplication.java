package es.apipharmashop.apipharmashop;

import es.apipharmashop.apipharmashop.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class ApiPharmaShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiPharmaShopApplication.class, args);
    }

}
