package nl.novi.zaligijsfeest.repository;

import nl.novi.zaligijsfeest.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
