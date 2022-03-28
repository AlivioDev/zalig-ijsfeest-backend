package nl.novi.zaligijsfeest.Repository;

import nl.novi.zaligijsfeest.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
