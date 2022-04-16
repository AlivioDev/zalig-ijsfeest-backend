package nl.novi.zaligijsfeest.model;

import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Order {
    //Variabelen
    @Id
    @GeneratedValue
    private Long id;


    private Double orderAmount;
    private String pickupDate;
    private Boolean paymentStatus;

    //TODO relatie leggen met orderline
//    @OneToMany
    private String orderLine;

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
