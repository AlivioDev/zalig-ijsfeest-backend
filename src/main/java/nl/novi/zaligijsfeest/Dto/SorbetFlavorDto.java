package nl.novi.zaligijsfeest.Dto;

//DTO voor sorbet smaken met constructors en getters en setters

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SorbetFlavorDto {
    //variabelen
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    //constructors
    //default constructor
    public SorbetFlavorDto() {
    }

    //constructor sorbet smaak naam
    public SorbetFlavorDto(String name) {
        this.name = name;
    }

    //volledige constructor
    public SorbetFlavorDto(Long id, String name) {
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
