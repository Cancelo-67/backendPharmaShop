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

    private Number amount;

    @ManyToOne
    private User user;

    public Order(Date date, Number amount) {
        this.date = date;
        this.amount = amount;
    }
}
