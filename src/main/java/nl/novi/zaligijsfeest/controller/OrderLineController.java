package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.OrderDto;
import nl.novi.zaligijsfeest.dto.OrderLineDto;
import nl.novi.zaligijsfeest.service.OrderLineService;
import nl.novi.zaligijsfeest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:3000")
@RequestMapping(path = "/orderlines")
public class OrderLineController {

    //Koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    OrderLineService orderLineService;

    //een GET-request voor alle bestelregels
    @GetMapping(path ="")
    public ResponseEntity<Object> getOrderLines() {
        List<OrderLineDto> orderLineDtoList = orderLineService.getOrderLines();
        return new ResponseEntity<>(orderLineDtoList, HttpStatus.OK);
    }

    //en GET-request voor 1 bestelregel
    @GetMapping(path ="/{id")
    public ResponseEntity<Object> getOrderLine(@PathVariable("id") Long id) {
        OrderLineDto orderLineDto = orderLineService.getOrderLine(id);
        return new ResponseEntity<>(orderLineDto, HttpStatus.OK);
    }

    //een POST-request voor 1 bestelregel
    @PostMapping(path ="")
    public ResponseEntity<Object> createOrderLine(@RequestBody OrderLineDto orderLineDto) {
        OrderLineDto orderLine = orderLineService.addOrderLine(orderLineDto);
        return new ResponseEntity<>(orderLine, HttpStatus.CREATED);
    }

    //een DELETE-request voor 1 bestelregel
    @DeleteMapping(path ="/{id}")
    public ResponseEntity<Object> deleteOrderLine(@PathVariable("id") Long id) {
        orderLineService.deleteOrderLine(id);
        return new ResponseEntity<>("Bestelling " + id + " verwijderd.", HttpStatus.FOUND);
    }

    //een PUT-request voor 1 bestelregel
    @PutMapping(path ="/{id}")
    public ResponseEntity<Object> updateOrderLine(@PathVariable("id") Long id, @RequestBody OrderLineDto orderLineDto) {
        OrderLineDto orderLine = orderLineService.updateOrderLine(id, orderLineDto);
        return new ResponseEntity<>(orderLine, HttpStatus.OK);
    }
}
