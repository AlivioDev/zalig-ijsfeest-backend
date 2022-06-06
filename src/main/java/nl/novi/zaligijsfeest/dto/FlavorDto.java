package nl.novi.zaligijsfeest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FlavorDto {

    @NotBlank
    @NotNull
    private String name;

    public FlavorDto() {
    }

    public FlavorDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
