package es.apipharmashop.apipharmashop.repositories;

import es.apipharmashop.apipharmashop.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
