package es.apipharmashop.apipharmashop.models;


import jakarta.persistence.Column;
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

    private String category;

    private Number price;

    @Column(length = 1000)
    private String description;

    private Integer stock;
    @Column(length = 10000)
    private String resume;

    public Product(String image, String name, String category, Number price, String description, Integer stock, String resume) {
        this.image = image;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.resume = resume;
    }
}
