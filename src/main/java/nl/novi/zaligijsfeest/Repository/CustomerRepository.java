package nl.novi.zaligijsfeest.Repository;

import nl.novi.zaligijsfeest.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Long> {
}
