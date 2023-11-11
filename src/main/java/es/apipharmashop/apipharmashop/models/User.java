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

    public enum Role {
        ADMIN,
        USER,
        BANNED
    }
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    private String phoneNumber;

    private String email;

    private String password;

    private String address;

    private String cart;


    //Relacion con el modelo Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();


    public User(Long id, String username, String surname, Role role, String phoneNumber, String email, String password, String address, String cart, Set<Order> orders) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.address = address;
        this.cart = cart;
        this.orders = orders;
    }

    public User(String username, String surname, Role role, String phoneNumber, String email, String password, String address, String cart, Set<Order> orders) {
        this.username = username;
        this.surname = surname;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.address = address;
        this.cart = cart;
        this.orders = orders;
    }

    //public boolean isAdmin() {return admin;}
}