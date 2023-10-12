package es.apipharmashop.apipharmashop.repositories;

import es.apipharmashop.apipharmashop.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
