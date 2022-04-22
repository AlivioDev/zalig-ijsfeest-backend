package nl.novi.zaligijsfeest.model;

import javax.persistence.*;

@Entity
@Table(name = "orderlines")
public class OrderLine {
    //Variabelen
    @Id
    @GeneratedValue
    private Long id;

    private String productName;
    private String flavors;
    private String numberOfPersons;
    private String Price;

    //TODO relatie leggen met order
//    @ManyToOne
//    Order order;

    //getters
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getNumberOfPersons() {
        return numberOfPersons;
    }

    public String getFlavors() {
        return flavors;
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

    public void setNumberOfPersons(String numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public void setPrice(String price) {
        Price = price;
    }
}
