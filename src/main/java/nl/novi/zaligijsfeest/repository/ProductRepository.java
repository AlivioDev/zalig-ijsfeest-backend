package nl.novi.zaligijsfeest.repository;

import nl.novi.zaligijsfeest.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
