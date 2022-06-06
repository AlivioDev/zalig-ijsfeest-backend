package nl.novi.zaligijsfeest.repository;

import nl.novi.zaligijsfeest.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, String> {
    List<OrderLine> findOrderLinesByIdStartingWith(String username);
    }
