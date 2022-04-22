package nl.novi.zaligijsfeest.model;

// maak variabelen voor de roomijs gegevens id en naam
// maak getters en setters

/* ik kies hier voor een aparte lijst om toevoegen en wijzigen van roomijs smaken voor de admin mooi apart te houden van de ijstaarten en sorbet smaken
 en in de client en database overzichtelijke scheiding tussen deze categoriën*/

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "icecreamflavors")
public class IceCreamFlavor {
    //variabelen
    @Id
    String name;

    //Getters
    public String getName() {
        return name;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
}
