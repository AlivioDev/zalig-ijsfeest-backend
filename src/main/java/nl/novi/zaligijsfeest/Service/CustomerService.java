package nl.novi.zaligijsfeest.Service;

import nl.novi.zaligijsfeest.Dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    //Methode voor het ophalen van alle customers
    List<CustomerDto> getCustomers();

    //Methode voor het opvragen van een customer
    CustomerDto getCustomerById(Long id);

    //Methode voor het toevoegen van een customer
    CustomerDto addCustomer(CustomerDto dto);

    //Methode voor het verwijderen van een customer
    void deleteCustomer(Long id);

    //Methode voor het updaten van een customer
    CustomerDto updateCustomer(Long id, CustomerDto dto);
}
