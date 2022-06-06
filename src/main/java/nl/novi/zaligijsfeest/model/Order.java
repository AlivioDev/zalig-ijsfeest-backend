package nl.novi.zaligijsfeest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private Double orderAmount;
    private String pickupDate;
    private String paymentStatus;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<OrderLine> orderLines = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;



    public Long getId() {
        return id;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public User getUser() {
        return user;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
