package nl.novi.zaligijsfeest.repository;

import nl.novi.zaligijsfeest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderRepository extends JpaRepository<Order, Long> {
}
