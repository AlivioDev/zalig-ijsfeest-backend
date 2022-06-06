package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.OrderLineDto;
import nl.novi.zaligijsfeest.service.OrderLineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/orderlines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }

    @GetMapping(path ="")
    public ResponseEntity<Object> getOrderLines() {
        List<OrderLineDto> orderLineDtoList = orderLineService.findOrderLines();
        return new ResponseEntity<>(orderLineDtoList, HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<Object> getOrderLinesByUser(@PathVariable("username") String username) {
        List<OrderLineDto> orderLineDtoList = orderLineService.findOrderLinesByUsername(username);
        return new ResponseEntity<>(orderLineDtoList, HttpStatus.OK);
    }

    @PostMapping(path ="")
    public ResponseEntity<Object> createOrderLine(@RequestBody OrderLineDto orderLineDto) {
        OrderLineDto orderLine = orderLineService.addOrderLine(orderLineDto);
        return new ResponseEntity<>(orderLine, HttpStatus.CREATED);
    }

    @PutMapping(path ="/update/{id}")
    public ResponseEntity<Object> updateOrderLine(@PathVariable("id") String id, @RequestBody OrderLineDto orderLineDto) {
        OrderLineDto orderLine = orderLineService.updateOrderLine(id, orderLineDto);
        return new ResponseEntity<>(orderLine, HttpStatus.OK);
    }
}
