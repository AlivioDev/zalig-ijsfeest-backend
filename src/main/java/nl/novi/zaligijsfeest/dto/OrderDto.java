package nl.novi.zaligijsfeest.dto;


import nl.novi.zaligijsfeest.model.OrderLine;
import nl.novi.zaligijsfeest.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class OrderDto {
    //Variabelen
    @NotBlank
    @NotNull
    private Long id;

    @NotBlank
    @NotNull
    private Double orderAmount;

    @NotBlank
    @NotNull
    private String pickupDate;

    @NotBlank
    @NotNull
    private Boolean paymentStatus;

    private List<OrderLine> orderLines;

    private User user;

    //constructors
    //default
    public OrderDto() {
    }

    //volledig
    public OrderDto(Long id,
                    Double orderAmount,
                    String pickupDate,
                    Boolean paymentStatus,
                    List<OrderLine> orderLines,
                    User user) {
        this.id = id;
        this.orderAmount = orderAmount;
        this.pickupDate = pickupDate;
        this.paymentStatus = paymentStatus;
        this.orderLines = orderLines;
        this.user = user;
    }


    //getters
    public Long getId() {
        return id;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public User getUser() {
        return user;
    }

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
