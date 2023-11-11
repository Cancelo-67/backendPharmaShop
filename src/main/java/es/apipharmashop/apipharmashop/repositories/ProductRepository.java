package es.apipharmashop.apipharmashop.repositories;

import es.apipharmashop.apipharmashop.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE UPPER(p.category) = UPPER(:category)")
    List<Product> findByCategory(@Param("category") String category);
}
