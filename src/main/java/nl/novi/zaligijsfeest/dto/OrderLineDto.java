package nl.novi.zaligijsfeest.dto;

import nl.novi.zaligijsfeest.model.Order;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderLineDto {

    private String id;

    @NotBlank
    @NotNull
    private String productName;

    private String flavors;

    @NotBlank
    @NotNull
    private String options;

    private Integer persons;

    @NotBlank
    @NotNull
    private Double price;

    private Long dateCreated;

    private Order order;


    public OrderLineDto() {
    }

    public OrderLineDto(String id, String productName, String flavors, String options, Integer persons, Double price, Long dateCreated, Order order) {
        this.id = id;
        this.productName = productName;
        this.flavors = flavors;
        this.options = options;
        this.persons = persons;
        this.price = price;
        this.dateCreated = dateCreated;
        this.order = order;
    }

    public OrderLineDto(String id, String productName, String flavors, String options, double price) {
        this.id = id;
        this.productName = productName;
        this.flavors = flavors;
        this.options = options;
        this.price = price;
    }


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

    public Long getDateCreated() {
        return dateCreated;
    }

    public Order getOrder() {
        return order;
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
