package nl.novi.zaligijsfeest.Service;

import nl.novi.zaligijsfeest.Dto.ProductDto;
import nl.novi.zaligijsfeest.Exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.Model.Product;
import nl.novi.zaligijsfeest.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    //Koppeling met de repository
    @Autowired
    ProductRepository productRepository;

    //methode voor het opvragen van alle producten
    @Override
    public List<ProductDto> getProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();

        for(Product product : productList) {
            ProductDto dto = transferToDto(product);
            productDtoList.add(dto);
        }
        return productDtoList;
    }

    //methode voor het opvragen van een product middels het id
    @Override
    public ProductDto getProductById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            Product product = productRepository.findById(id).get();
            ProductDto dto = transferToDto(product);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen product gevonden met id " + id + ".");
        }
    }

    //methode voor het toevoegen van een product
    @Override
    public ProductDto addProduct(ProductDto dto) {
        Product product = transferToProduct(dto);
        productRepository.save(product);
        return dto;
    }

    //methode voor het verwijderen van een product middels het id
    @Override
    public void deleteProduct(Long id) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("Geen product gevonden met id " + id + ".");
        }
    }

    //methode voor het updaten van een product middels het id
    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        if (productRepository.findById(id).isPresent()) {
            Product product = productRepository.findById(id).get();

            product.setId(product.getId()); //TODO: vragen of dit met opzet product.get is ipv dto.get
            product.setProductName(dto.getProductName());
            product.setNumberOfPersonsOne(dto.getNumberOfPersonsOne());
            product.setNumberOfPersonsTwo(dto.getNumberOfPersonsTwo());
            product.setNumberOfPersonsThree(dto.getNumberOfPersonsThree());
            product.setPriceOne(dto.getPriceOne());
            product.setPriceTwo(dto.getPriceTwo());
            product.setPriceThree(dto.getPriceThree());

            productRepository.save(product);
            return dto;
        } else {
            throw new RecordNotFoundException("Geen product gevonden met id " + id + ".");
        }
    }


    //methode om de gegevens vanuit de dto aan de entity door te geven
    public Product transferToProduct(ProductDto dto) {
        var product = new Product();

        product.setId(dto.getId()); //TODO: vragen of dit met opzet dto.get is
        product.setProductName(dto.getProductName());
        product.setNumberOfPersonsOne(dto.getNumberOfPersonsOne());
        product.setNumberOfPersonsTwo(dto.getNumberOfPersonsTwo());
        product.setNumberOfPersonsThree(dto.getNumberOfPersonsThree());
        product.setPriceOne(dto.getPriceOne());
        product.setPriceTwo(dto.getPriceTwo());
        product.setPriceThree(dto.getPriceThree());

        return product;
    }

    //methode om de gegevens uit de entity aan de dto door te geven
    public ProductDto transferToDto(Product product) {
        var dto = new ProductDto();

        dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setNumberOfPersonsOne(product.getNumberOfPersonsOne());
        dto.setNumberOfPersonsTwo(product.getNumberOfPersonsTwo());
        dto.setNumberOfPersonsThree(product.getNumberOfPersonsThree());
        dto.setPriceOne(product.getPriceOne());
        dto.setPriceTwo(product.getPriceTwo());
        dto.setPriceThree(product.getPriceThree());

        return dto;
    }

}
