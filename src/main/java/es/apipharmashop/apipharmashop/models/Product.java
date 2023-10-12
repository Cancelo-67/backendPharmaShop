package es.apipharmashop.apipharmashop.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String image;

    private String name;

    private Number price;

    private String description;

    private Integer age;

    public Product(String image, String name, Number price, String description, Integer age) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
        this.age = age;
    }
}