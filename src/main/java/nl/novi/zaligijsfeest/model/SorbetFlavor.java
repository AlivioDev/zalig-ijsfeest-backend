package nl.novi.zaligijsfeest.model;

// maak een variabele voor de sorbet smaken
// maak getters en setters

/* ik kies hier voor een aparte lijst om toevoegen en wijzigen van sorbet smaken voor de admin mooi apart te houden van de ijstaarten en roomijs smaken
 en in de client en database overzichtelijke scheiding tussen deze categoriën*/


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sorbetflavors")
public class SorbetFlavor {
    //Variabelen
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
