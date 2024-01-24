package es.apipharmashop.apipharmashop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private Number id_product;

    private Number id_user;

    private String name;

    private String comment;

    public Comment(Number id_product, Number id_user, String name, String comment) {
        this.id_product = id_product;
        this.id_user = id_user;
        this.name = name;
        this.comment = comment;
    }
}
