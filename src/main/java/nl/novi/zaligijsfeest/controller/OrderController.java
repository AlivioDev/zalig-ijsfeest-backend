package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.OrderDto;
import nl.novi.zaligijsfeest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(path ="/user/{username}")
    public ResponseEntity<Object> getOrdersByUserUsername(@PathVariable("username") String user_username) {
        List<OrderDto> orderDtoList = orderService.findOrdersByUserUsername(user_username);
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }

    @PostMapping(path ="")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto order = orderService.addOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

}
