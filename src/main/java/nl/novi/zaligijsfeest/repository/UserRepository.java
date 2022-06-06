package nl.novi.zaligijsfeest.repository;

import nl.novi.zaligijsfeest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, String> {
}
