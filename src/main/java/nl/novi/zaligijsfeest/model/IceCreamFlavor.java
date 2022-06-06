package nl.novi.zaligijsfeest.model;

import javax.persistence.*;

@Entity
@Table(name = "icecreamflavors")
public class IceCreamFlavor {

    @Id
    String name;

    public IceCreamFlavor() {
    }

    public IceCreamFlavor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
