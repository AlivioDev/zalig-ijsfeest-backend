package nl.novi.zaligijsfeest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderLineDto {

    private Long id;

    @NotBlank
    @NotNull
    private String productName;

    private String flavors;

    @NotBlank
    @NotNull
    private String numberOfPersons;

    @NotBlank
    @NotNull
    private String Price;

    //constructors
    //default
    public OrderLineDto() {
    }

    //volledig
    public OrderLineDto(Long id, String productName, String flavors, String numberOfPersons, String price) {
        this.id = id;
        this.productName = productName;
        this.flavors = flavors;
        this.numberOfPersons = numberOfPersons;
        Price = price;
    }

    //getters
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getFlavors() {
        return flavors;
    }

    public String getNumberOfPersons() {
        return numberOfPersons;
    }

    public String getPrice() {
        return Price;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public void setNumberOfPersons(String numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
