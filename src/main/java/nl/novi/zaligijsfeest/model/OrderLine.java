package nl.novi.zaligijsfeest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "orderlines")
public class OrderLine {

    @Id
    private String id;

    private String productName;
    private String flavors;
    private String options;
    private Integer persons;
    private Double price;
    private Long dateCreated;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "order_id")
    private Order order;


    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getFlavors() {
        return flavors;
    }

    public String getOptions() {
        return options;
    }

    public Integer getPersons() {
        return persons;
    }

    public Double getPrice() {
        return price;
    }

    public Order getOrder() {
        return order;
    }

    public Long getDateCreated() {
        return dateCreated;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setFlavors(String flavors) {
        this.flavors = flavors;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public void setPersons(Integer persons) {
        this.persons = persons;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setDateCreated(Long dateCreated) {
        this.dateCreated = dateCreated;
    }
}
