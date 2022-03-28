package nl.novi.zaligijsfeest.Dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SorbetFlavorDto {
    //variabelen
    private Long id;

    @NotBlank
    @NotNull
    private String name;

    //constructors
    public SorbetFlavorDto() {
    }

    public SorbetFlavorDto(String name) {
        this.name = name;
    }

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
