package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders();
    List<OrderDto> findOrdersByUserUsername(String user_username);
    OrderDto addOrder(OrderDto orderDto);

}
