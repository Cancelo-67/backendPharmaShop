package es.apipharmashop.apipharmashop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    private String name;

    private String surname;

    public enum Role {
        ADMIN,
        USER,
        BANNED
    }
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    private String birthdate;

    private String email;

    private String password;

    private String address;

    @ElementCollection
    private List<Long> favorites;

    //Relacion con el modelo Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();


    public User(Long id,String username,String name, String surname,Role role, String birthdate, String email, String password, String address, List<Long> favorites, Set<Order> orders) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.birthdate = birthdate;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.address = address;
        this.favorites = favorites;
        this.orders = orders;
    }

    //Constructor para login y actualizar el token
}