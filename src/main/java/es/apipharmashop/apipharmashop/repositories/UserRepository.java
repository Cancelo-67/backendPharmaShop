package es.apipharmashop.apipharmashop.repositories;

import es.apipharmashop.apipharmashop.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long> {
    User findByUsername(String username);

    boolean existsByUsername(String username);
}
