package nl.novi.zaligijsfeest.Model;

// maak variabelen voor de roomijs gegevens id en naam
// maak getters en setters
// hiervoor een aparte lijst om toevoegen en wijzigen van smaken voor de admin mooi apart te houden van de ijstaarten
// en in de code en database overzichtelijke scheiding tussen deze categoriën

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "icecreamflavors")
public class IceCreamFlavor {
    //variabelen
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
