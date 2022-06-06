package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderLineDto;

import java.util.List;

public interface OrderLineService {
    List<OrderLineDto> findOrderLines();
    List<OrderLineDto> findOrderLinesByUsername(String username);
    OrderLineDto addOrderLine(OrderLineDto orderLineDto);
    OrderLineDto updateOrderLine(String id, OrderLineDto orderLineDto);
}
