package nl.novi.zaligijsfeest.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SorbetFlavor {
    //Variabelen
    @Id
    @GeneratedValue
    Long Id;
    String name;

    //Getters
    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
