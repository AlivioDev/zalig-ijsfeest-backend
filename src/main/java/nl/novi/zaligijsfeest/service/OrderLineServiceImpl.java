package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderLineDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.OrderLine;
import nl.novi.zaligijsfeest.repository.OrderLineRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderLineServiceImpl implements OrderLineService {


    private final OrderLineRepository orderLineRepository;

    public OrderLineServiceImpl(@Lazy OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public List<OrderLineDto> findOrderLines() {
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

    @Override
    public List<OrderLineDto> findOrderLinesByUsername(String username) {
        if (!orderLineRepository.findOrderLinesByIdStartingWith(username).isEmpty()) {
            List<OrderLineDto> orderLineDtoList = new ArrayList<>();
            List<OrderLine> orderLineList = orderLineRepository.findOrderLinesByIdStartingWith(username);
            for (OrderLine orderLine : orderLineList) {
                orderLineDtoList.add(fromOrderLine(orderLine));
            }
            return orderLineDtoList;
        } else {
            throw new RecordNotFoundException("Er zijn geen bestelregels gevonden");
        }
    }

    @Override
    public OrderLineDto addOrderLine(OrderLineDto orderLineDto) {
        OrderLine orderLine = toOrderLine(orderLineDto);
        orderLineRepository.save(orderLine);
        return orderLineDto;
    }

    @Override
    public OrderLineDto updateOrderLine(String id, OrderLineDto orderLineDto) {
        if (orderLineRepository.existsById(id)) {
            OrderLine orderLine = orderLineRepository.findById(id).get();

            orderLine.setId(orderLine.getId());
            orderLine.setProductName(orderLineDto.getProductName());
            orderLine.setFlavors(orderLineDto.getFlavors());
            orderLine.setOptions(orderLineDto.getOptions());
            orderLine.setPersons(orderLineDto.getPersons());
            orderLine.setPrice(orderLineDto.getPrice());
            orderLine.setDateCreated(orderLineDto.getDateCreated());
            orderLine.setOrder(orderLineDto.getOrder());

            orderLineRepository.save(orderLine);
            return orderLineDto;
        } else {
            throw new RecordNotFoundException("Geen gegevens gevonden met id " + id + ".");
        }
    }

    public OrderLine toOrderLine(OrderLineDto orderLineDto) {
        var orderLine = new OrderLine();

        orderLine.setId(orderLineDto.getId());
        orderLine.setProductName(orderLineDto.getProductName());
        orderLine.setFlavors(orderLineDto.getFlavors());
        orderLine.setOptions(orderLineDto.getOptions());
        orderLine.setPersons(orderLineDto.getPersons());
        orderLine.setPrice(orderLineDto.getPrice());
        orderLine.setDateCreated(orderLineDto.getDateCreated());
        orderLine.setOrder(orderLineDto.getOrder());

        return orderLine;
    }

    public static OrderLineDto fromOrderLine(OrderLine orderLine) {
        var orderLineDto = new OrderLineDto();

        orderLineDto.setId(orderLine.getId());
        orderLineDto.setProductName(orderLine.getProductName());
        orderLineDto.setFlavors(orderLine.getFlavors());
        orderLineDto.setOptions(orderLine.getOptions());
        orderLineDto.setPersons(orderLine.getPersons());
        orderLineDto.setPrice(orderLine.getPrice());
        orderLineDto.setDateCreated(orderLine.getDateCreated());
        orderLineDto.setOrder(orderLine.getOrder());

        return orderLineDto;
    }
}

