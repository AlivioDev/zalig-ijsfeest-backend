package nl.novi.zaligijsfeest.dto;

import nl.novi.zaligijsfeest.model.Order;

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
    private String options;

    private Integer persons;

    @NotBlank
    @NotNull
    private Double price;

    private Order order;

    //constructors
    //default
    public OrderLineDto() {
    }

    //volledig
    public OrderLineDto(Long id, String productName, String flavors, String options, Integer persons, Double price, Order order) {
        this.id = id;
        this.productName = productName;
        this.flavors = flavors;
        this.options = options;
        this.persons = persons;
        this.price = price;
        this.order = order;
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
        this.order = this.order;
    }
}
