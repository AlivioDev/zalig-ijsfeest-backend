package nl.novi.zaligijsfeest.model;

// maak variabelen voor de sorbet gegevens id en naam
// maak getters en setters
// hiervoor een aparte lijst om toevoegen en wijzigen van sorbet smaken voor de admin mooi apart te houden van de ijstaarten en roomijs smaken
// en in de code en database overzichtelijke scheiding tussen deze categoriën

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sorbetflavors")
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
