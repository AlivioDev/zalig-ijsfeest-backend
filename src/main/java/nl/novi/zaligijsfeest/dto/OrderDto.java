package nl.novi.zaligijsfeest.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OrderDto {
    //Variabelen
    @NotBlank
    @NotNull
    private Long id;

    @NotBlank
    @NotNull
    private String orderLine;

    @NotBlank
    @NotNull
    private Double orderAmount;

    @NotBlank
    @NotNull
    private String pickupDate;

    @NotBlank
    @NotNull
    private Boolean paymentStatus;

    //constructors
    //default
    public OrderDto() {
    }

    //volledig
    public OrderDto(Long id, String orderLine, Double orderAmount, String pickupDate, Boolean paymentStatus) {
        this.id = id;
        this.orderLine = orderLine;
        this.orderAmount = orderAmount;
        this.pickupDate = pickupDate;
        this.paymentStatus = paymentStatus;
    }

    //getters

    public Long getId() {
        return id;
    }

    public String getOrderLine() {
        return orderLine;
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

    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderLine(String orderLine) {
        this.orderLine = orderLine;
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
}
