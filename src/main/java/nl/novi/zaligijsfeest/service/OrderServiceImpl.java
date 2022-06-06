package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.Order;
import nl.novi.zaligijsfeest.repository.OrderRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(@Lazy OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public List<OrderDto> getOrders() {
        if (!orderRepository.findAll().isEmpty()) {
            List<OrderDto> orderDtoList = new ArrayList<>();
            List<Order> orderList = orderRepository.findAll();
            for (Order order : orderList) {
                orderDtoList.add(fromOrder(order));
            }
            return orderDtoList;
        } else {
            throw new RecordNotFoundException("Er zijn geen bestellingen gevonden");
        }
    }

    @Override
    public List<OrderDto> findOrdersByUserUsername(String user_username) {
        if (!orderRepository.findOrdersByUserUsername(user_username).isEmpty()) {
            List<OrderDto> orderDtoList = new ArrayList<>();
            List<Order> orderList = orderRepository.findOrdersByUserUsername(user_username);
            for (Order order: orderList) {
                orderDtoList.add(fromOrder(order));
            }
            return orderDtoList;
        }else {
            throw new RecordNotFoundException("Er zijn geen bestellingen gevonden voor " + user_username + ".");
        }
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = toOrder(orderDto);
        orderRepository.save(order);
        return orderDto;
    }

    public Order toOrder(OrderDto orderDto) {
        var order = new Order();

        order.setId(orderDto.getId());
        order.setOrderLines(orderDto.getOrderLines());
        order.setOrderAmount(orderDto.getOrderAmount());
        order.setPaymentStatus(orderDto.getPaymentStatus());
        order.setPickupDate(orderDto.getPickupDate());
        order.setUser(orderDto.getUser());

        return order;
    }

    public static OrderDto fromOrder(Order order) {
        var orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setOrderLines(order.getOrderLines());
        orderDto.setOrderAmount(order.getOrderAmount());
        orderDto.setPaymentStatus(order.getPaymentStatus());
        orderDto.setPickupDate(order.getPickupDate());
        orderDto.setUser(order.getUser());

        return orderDto;
    }


}
