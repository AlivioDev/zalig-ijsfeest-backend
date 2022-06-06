package nl.novi.zaligijsfeest.repository;

import nl.novi.zaligijsfeest.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersByUserUsername(String user_username);
}
