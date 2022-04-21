package nl.novi.zaligijsfeest.model;

// maak variabelen aan voor de volgende ijstaart-gegevens: id, productnaam, personenopties, prijsopties
// maak getters en setters

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table (name = "products")
public class Product {
    //Variabelen
    @Id
    @GeneratedValue
    private Long id;

    private String productName;
    private String numberOfPersonsOne;
    private String numberOfPersonsTwo;
    private String numberOfPersonsThree;
    private Integer perPerson;
    private Double priceOne;
    private Double priceTwo;
    private Double priceThree;

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

    public Integer getPerPerson() {
        return perPerson;
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

    public void setPerPerson(Integer perPerson) {
        this.perPerson = perPerson;
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
