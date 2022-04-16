package nl.novi.zaligijsfeest.dto;

//DTO voor smaken met constructors en getters en setters

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlavorDto {
    //variabelen
    @NotBlank
    @NotNull
    private String name;

    //Constructors
    //default constructor
    public FlavorDto() {
    }

    //volledige constructor
    public FlavorDto(String name) {
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }


    //Setters
    public void setName(String name) {
        this.name = name;
    }


}
