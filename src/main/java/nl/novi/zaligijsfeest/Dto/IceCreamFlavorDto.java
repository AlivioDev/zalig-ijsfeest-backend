package nl.novi.zaligijsfeest.Dto;

//DTO voor roomijs smaken met constructors en getters en setters

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class IceCreamFlavorDto {
    //variabelen
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    //Constructors
    //default constructor
    public IceCreamFlavorDto() {
    }

    //constructor voor de ijssmaak naam
    public IceCreamFlavorDto(String name) {
        this.name = name;
    }

    //volledige constructor
    public IceCreamFlavorDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
