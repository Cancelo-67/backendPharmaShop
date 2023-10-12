package es.apipharmashop.apipharmashop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;


@Entity
@Getter@Setter
@NoArgsConstructor
@Table(name = "usercustom")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String surname;

    private Boolean admin;

    private String phoneNumber;

    private String email;

    private String password;

    private String keyApi;

    private String address;

    private String cart;


    //Relacion con el modelo Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();


    public User(Long id, String username, String surname, Boolean admin, String phoneNumber, String email, String password, String keyApi, String address, String cart) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.admin = admin;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.keyApi = keyApi;
        this.address = address;
        this.cart = cart;
    }

    public User(String username, String surname, Boolean admin, String phoneNumber, String email, String password, String keyApi, String address, String cart) {
        this.username = username;
        this.surname = surname;
        this.admin = admin;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.keyApi = keyApi;
        this.address = address;
        this.cart = cart;
    }
}