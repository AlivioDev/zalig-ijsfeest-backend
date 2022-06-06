package nl.novi.zaligijsfeest.model;

import javax.persistence.*;


@Entity
@Table(name = "sorbetflavors")
public class SorbetFlavor {

    @Id
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
