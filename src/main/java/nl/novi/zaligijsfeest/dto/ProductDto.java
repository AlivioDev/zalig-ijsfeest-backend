package nl.novi.zaligijsfeest.dto;

// Maak variabelen aan voor de volgende ijstaart-gegevens: id, productnaam, personenopties, prijsopties
// Maak constructors
// Maak getters en setters

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDto {
    //variabelen
    private Long id;

    @NotBlank
    @NotNull
    private String productName;

    @NotBlank
    @NotNull
    private String numberOfPersonsOne;

    private String numberOfPersonsTwo;
    private String numberOfPersonsThree;

    @NotBlank
    @NotNull
    private Double priceOne;

    private Double priceTwo;
    private Double priceThree;

    //Constructors
    //default constructor
    public ProductDto() {
    }

    //constructor voor ijstaart met 1 personen optie en 1 prijs optie
    public ProductDto(String productName, String numberOfPersonsOne, Double priceOne) {
        this.productName = productName;
        this.numberOfPersonsOne = numberOfPersonsOne;
        this.priceOne = priceOne;
    }

    //constructor voor ijstaart met 2 personen opties en 2 prijs opties
    public ProductDto(String productName, String numberOfPersonsOne, String numberOfPersonsTwo, Double priceOne, Double priceTwo) {
        this.productName = productName;
        this.numberOfPersonsOne = numberOfPersonsOne;
        this.numberOfPersonsTwo = numberOfPersonsTwo;
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;
    }

    //constructor voor ijstaart met 3 personen opties en 3 prijs opties
    public ProductDto(String productName, String numberOfPersonsOne, String numberOfPersonsTwo, String numberOfPersonsThree, Double priceOne, Double priceTwo, Double priceThree) {
        this.productName = productName;
        this.numberOfPersonsOne = numberOfPersonsOne;
        this.numberOfPersonsTwo = numberOfPersonsTwo;
        this.numberOfPersonsThree = numberOfPersonsThree;
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;
        this.priceThree = priceThree;
    }

    //volledige constructor
    public ProductDto(Long id,
                      String productName,
                      String numberOfPersonsOne,
                      String numberOfPersonsTwo,
                      String numberOfPersonsThree,
                      Double priceOne,
                      Double priceTwo,
                      Double priceThree) {
        this.id = id;
        this.productName = productName;
        this.numberOfPersonsOne = numberOfPersonsOne;
        this.numberOfPersonsTwo = numberOfPersonsTwo;
        this.numberOfPersonsThree = numberOfPersonsThree;
        this.priceOne = priceOne;
        this.priceTwo = priceTwo;
        this.priceThree = priceThree;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getNumberOfPersonsOne() {
        return numberOfPersonsOne;
    }

    public String getNumberOfPersonsTwo() {
        return numberOfPersonsTwo;
    }

    public String getNumberOfPersonsThree() {
        return numberOfPersonsThree;
    }

    public Double getPriceOne() {
        return priceOne;
    }

    public Double getPriceTwo() {
        return priceTwo;
    }

    public Double getPriceThree() {
        return priceThree;
    }


    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setNumberOfPersonsOne(String numberOfPersonsOne) {
        this.numberOfPersonsOne = numberOfPersonsOne;
    }

    public void setNumberOfPersonsTwo(String numberOfPersonsTwo) {
        this.numberOfPersonsTwo = numberOfPersonsTwo;
    }

    public void setNumberOfPersonsThree(String numberOfPersonsThree) {
        this.numberOfPersonsThree = numberOfPersonsThree;
    }

    public void setPriceOne(Double priceOne) {
        this.priceOne = priceOne;
    }

    public void setPriceTwo(Double priceTwo) {
        this.priceTwo = priceTwo;
    }

    public void setPriceThree(Double priceThree) {
        this.priceThree = priceThree;
    }

}
