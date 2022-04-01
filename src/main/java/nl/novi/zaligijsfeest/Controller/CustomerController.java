package nl.novi.zaligijsfeest.Controller;

import nl.novi.zaligijsfeest.Dto.CustomerDto;
import nl.novi.zaligijsfeest.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    //Koppeling met de servicelaag o de methoden te kunnen gebruiken
    @Autowired
    CustomerService customerService;

    //een GET-request voor alle customers
    @GetMapping(path = "/customers")
    public ResponseEntity<Object> getCustomers() {
        List<CustomerDto> customerDtoList = customerService.getCustomers();
        return new ResponseEntity<>(customerDtoList, HttpStatus.OK);
    }

    //een GET-request voor 1 customer
    @GetMapping(path = "/customers/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    //een POST-request voor 1 customer
    @PostMapping("/customers")
    public ResponseEntity<Object> addCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerService.addCustomer(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    //een DELETE-request voor 1 customer
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Customer verwijderd", HttpStatus.FOUND);
    }

    //een PUT-request voor 1 customer
    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerDto customerDto) {
        CustomerDto customer = customerService.updateCustomer(id, customerDto);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
