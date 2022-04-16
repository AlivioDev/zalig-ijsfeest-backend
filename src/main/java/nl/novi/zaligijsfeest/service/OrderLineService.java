package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderLineDto;

import java.util.List;

public interface OrderLineService {
    //methode voor het opvragen van alle bestelregels
    List<OrderLineDto> getOrderLines();

    //Methode voor het opvragen van een bestelregel
    OrderLineDto getOrderLine(Long id);

    //Methode voor het toevoegen van een bestelregel
    OrderLineDto addOrderLine(OrderLineDto orderLineDto);

    //Methode voor het verwijderen van een bestelregel
    void deleteOrderLine(Long id);

    //Methode voor het wijzigen van een bestelregel
    OrderLineDto updateOrderLine(Long id, OrderLineDto orderLineDto);
}
