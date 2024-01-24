package es.apipharmashop.apipharmashop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usercustom")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String surname;

    private String gender;

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

    private String token;

    private List<Long> favorites;


    //Relacion con el modelo Order
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();


    public User(String username, String surname, String gender,Role role, String birthdate, String email, String password, String address, String token, List<Long> favorites, Set<Order> orders) {
        this.username = username;
        this.surname = surname;
        this.gender = gender;
        this.role = role;
        this.birthdate = birthdate;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.address = address;
        this.token = token;
        this.favorites = favorites;
        this.orders = orders;
    }

    //Constructor para login y actualizar el token
    public User(String username, String surname, String token) {
        this.username = username;
        this.surname = surname;
        this.token = token;
    }
}