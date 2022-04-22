package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.OrderDto;
import nl.novi.zaligijsfeest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    //Koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    OrderService orderService;

    //een GET-request voor alle bestellingen
    @GetMapping(path ="")
    public ResponseEntity<Object> getOrders() {
        List<OrderDto> orderDtoList = orderService.getOrders();
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }

    //en GET-request voor 1 bestelling
    @GetMapping(path ="/{id")
    public ResponseEntity<Object> getOrder(@PathVariable("id") Long id) {
        OrderDto orderDto = orderService.getOrder(id);
        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    //een POST-request voor 1 bestelling
    @PostMapping(path ="")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto order = orderService.addOrder(orderDto);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    //een DELETE-request voor 1 bestelling
    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Bestelling " + id + " verwijderd.", HttpStatus.FOUND);
    }

    //een PUT-request voor 1 bestelling
    @PutMapping(path ="/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Long id, @RequestBody OrderDto orderDto) {
        OrderDto order = orderService.updateOrder(id, orderDto);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
