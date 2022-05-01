package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderLineDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.OrderLine;
import nl.novi.zaligijsfeest.repository.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    OrderLineRepository orderLineRepository;

    //methode voor het opvragen van alle bestelregels
    @Override
    public List<OrderLineDto> getOrderLines() {
        if (!orderLineRepository.findAll().isEmpty()) {
            List<OrderLineDto> orderLineDtoList = new ArrayList<>();
            List<OrderLine> orderLineList = orderLineRepository.findAll();
            for (OrderLine orderLine : orderLineList) {
                orderLineDtoList.add(fromOrderLine(orderLine));
            }
            return orderLineDtoList;
        } else {
            throw new RecordNotFoundException("Er zijn geen bestelregels gevonden");
        }
    }

    //Methode voor het opvragen van een bestelregel
    @Override
    public OrderLineDto getOrderLine(Long id) {
        OrderLineDto orderLineDto;
        Optional<OrderLine> orderLine = orderLineRepository.findById(id);
        if (orderLine.isPresent()) {
            orderLineDto = fromOrderLine(orderLine.get());
        } else {
            throw new RecordNotFoundException("Er is geen bestelregel gevonden met id" + id + ".");
        }
        return orderLineDto;
    }

    //Methode voor het toevoegen van een bestelregel
    @Override
    public OrderLineDto addOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = toOrderLine(orderLineDto);
        orderLineRepository.save(orderLine);
        return orderLineDto;
    }

    //Methode voor het verwijderen van een bestelregel
    @Override
    public void deleteOrderLine(Long id) {
        orderLineRepository.deleteById(id);
    }

    //Methode voor het wijzigen van een bestelregel
    @Override
    public OrderLineDto updateOrderLine(Long id, OrderLineDto orderLineDto) {
        if (orderLineRepository.existsById(id)) {
            OrderLine orderLine = orderLineRepository.findById(id).get();

            orderLine.setId(orderLine.getId());
            orderLine.setProductName(orderLineDto.getProductName());
            orderLine.setFlavors(orderLineDto.getFlavors());
            orderLine.setOptions(orderLineDto.getOptions());
            orderLine.setPersons(orderLineDto.getPersons());
            orderLine.setPrice(orderLineDto.getPrice());
            orderLine.setOrder(orderLineDto.getOrder());

            orderLineRepository.save(orderLine);
            return orderLineDto;
        } else {
            throw new RecordNotFoundException("Geen gegevens gevonden met id " + id + ".");
        }
    }

    //Methode om de gegevens vanuit de dto aan de entity door te geven
    public OrderLine toOrderLine(OrderLineDto orderLineDto) {
        var orderLine = new OrderLine();

        orderLine.setId(orderLineDto.getId());
        orderLine.setProductName(orderLineDto.getProductName());
        orderLine.setFlavors(orderLineDto.getFlavors());
        orderLine.setOptions(orderLineDto.getOptions());
        orderLine.setPersons(orderLineDto.getPersons());
        orderLine.setPrice(orderLineDto.getPrice());
        orderLine.setOrder(orderLineDto.getOrder());

        return orderLine;
    }

    //Methode om de gegevens vanuit de entity door te geven aan de dto
    public static OrderLineDto fromOrderLine(OrderLine orderLine) {
        var orderLineDto = new OrderLineDto();

        orderLineDto.setId(orderLine.getId());
        orderLineDto.setProductName(orderLine.getProductName());
        orderLineDto.setFlavors(orderLine.getFlavors());
        orderLineDto.setOptions(orderLine.getOptions());
        orderLineDto.setPersons(orderLine.getPersons());
        orderLineDto.setPrice(orderLine.getPrice());
        orderLineDto.setOrder(orderLine.getOrder());

        return orderLineDto;
    }
}

