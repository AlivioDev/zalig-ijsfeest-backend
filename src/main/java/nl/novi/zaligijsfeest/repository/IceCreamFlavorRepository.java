package nl.novi.zaligijsfeest.repository;

import nl.novi.zaligijsfeest.model.IceCreamFlavor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IceCreamFlavorRepository extends JpaRepository<IceCreamFlavor, String> {
}
