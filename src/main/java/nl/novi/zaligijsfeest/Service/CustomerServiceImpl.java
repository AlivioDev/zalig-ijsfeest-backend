package nl.novi.zaligijsfeest.Service;

import nl.novi.zaligijsfeest.Dto.CustomerDto;
import nl.novi.zaligijsfeest.Exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.Model.Customer;
import nl.novi.zaligijsfeest.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    //Koppeling met de Repository
    @Autowired
    CustomerRepository customerRepository;

    //Methode voor het ophalen van alle customers
    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDto> customerDtoList = new ArrayList<>();

        for(Customer customer : customerList) {
            CustomerDto dto = transferToDto(customer);
            customerDtoList.add(dto);
        }
        return customerDtoList;
    }

    //Methode voor het opvragen van een customer
    @Override
    public CustomerDto getCustomerById(Long id) {
        if (customerRepository.findById(id).isPresent()) {
            Customer customer = customerRepository.findById(id).get();
            CustomerDto dto = transferToDto(customer);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen relatie gevonden met id " + id + ".");
        }
    }

    //Methode voor het toevoegen van een customer
    @Override
    public CustomerDto addCustomer(CustomerDto dto) {
        Customer customer = transferToCustomer(dto);
        customerRepository.save(customer);
        return dto;
    }

    //Methode voor het verwijderen van een customer
    @Override
    public void deleteCustomer(Long id) {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Geen relatie gevonden met id " + id + ".");
        }
    }

    //Methode voor het updaten van een customer
    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto dto) {
        if (customerRepository.findById(id).isPresent()) {
            Customer customer = customerRepository.findById(id).get();

            customer.setId(customer.getId());
            customer.setName(dto.getName());
            customer.setEmail(dto.getEmail());
            customer.setPhoneNumber(dto.getPhoneNumber());

            customerRepository.save(customer);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen relatie gevonden met id " + id + ".");
        }
    }

    //Methode om de gegevens vanuit de dto aan de enitity door te geven
    public Customer transferToCustomer(CustomerDto dto) {
        var customer = new Customer();

        customer.setId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());

        return customer;
    }

    //Methode om de gegevens vanuit de entity door te geven aan de dto
    public CustomerDto transferToDto(Customer customer) {
        var dto = new CustomerDto();

        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhoneNumber(customer.getPhoneNumber());

        return dto;
    }
}
