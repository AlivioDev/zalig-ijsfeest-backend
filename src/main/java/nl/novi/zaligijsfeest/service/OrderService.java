package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders();
    OrderDto getOrder(Long id);
    OrderDto addOrder(OrderDto orderDto);
    void deleteOrder(Long id);
    OrderDto updateOrder(Long id, OrderDto orderDto);
}
