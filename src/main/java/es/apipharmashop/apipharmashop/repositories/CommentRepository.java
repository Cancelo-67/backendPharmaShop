package es.apipharmashop.apipharmashop.repositories;

import es.apipharmashop.apipharmashop.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
