package es.apipharmashop.apipharmashop.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordercustom")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    private Date date;

    @ManyToOne
    private User user;


    public Order(Date date) {
        this.date = date;
    }
}
