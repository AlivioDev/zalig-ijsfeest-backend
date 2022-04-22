package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.OrderDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.Order;
import nl.novi.zaligijsfeest.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    //methode voor het opvragen van alle orders
    @Override
    public List<OrderDto> getOrders() {
        if (!orderRepository.findAll().isEmpty()) {
            List<OrderDto> orderDtoList = new ArrayList<>();
            List<Order> orderList = orderRepository.findAll();
            for (Order order: orderList) {
                orderDtoList.add(fromOrder(order));
            }
              return orderDtoList;
            } else {
            throw new RecordNotFoundException("Er zijn geen bestellingen gevonden");
        }
    }
    //Methode voor het opvragen van een bestelling
    @Override
    public OrderDto getOrder(Long id) {
        OrderDto orderDto;
        Optional<Order> order = orderRepository.findById(id);
        if (order.isPresent()){
            orderDto = fromOrder(order.get());
        }else {
            throw new RecordNotFoundException("Er is geen bestelling gevonden met id" + id + ".");
        }
        return orderDto;
    }

    //Methode voor het toevoegen van een bestelling
    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = toOrder(orderDto);
        orderRepository.save(order);
        return orderDto;
    }

    //Methode voor het verwijderen van een bestelling
    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    //Methode voor het wijzigen van een bestelling
    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        if (orderRepository.existsById(id)) {
            Order order = orderRepository.findById(id).get();

            order.setId(order.getId());
            order.setOrderLine(orderDto.getOrderLine());
            order.setOrderAmount(orderDto.getOrderAmount());
            order.setPaymentStatus(orderDto.getPaymentStatus());
            order.setPickupDate(orderDto.getPickupDate());

            orderRepository.save(order);
            return orderDto;
        } else {
            throw new RecordNotFoundException("Geen gegevens gevonden met id " + id + ".");
        }
    }

    //Methode om de gegevens vanuit de dto aan de entity door te geven
    public Order toOrder(OrderDto orderDto) {
        var order = new Order();

        order.setId(orderDto.getId());
        order.setOrderLine(orderDto.getOrderLine());
        order.setOrderAmount(orderDto.getOrderAmount());
        order.setPaymentStatus(orderDto.getPaymentStatus());
        order.setPickupDate(orderDto.getPickupDate());

        return order;
    }

    //Methode om de gegevens vanuit de entity door te geven aan de dto
    public static OrderDto fromOrder(Order order) {
        var orderDto = new OrderDto();

        orderDto.setId(order.getId());
        orderDto.setOrderLine(order.getOrderLine());
        orderDto.setOrderAmount(order.getOrderAmount());
        orderDto.setPaymentStatus(order.getPaymentStatus());
        orderDto.setPickupDate(order.getPickupDate());

        return orderDto;
    }
}
