package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.ProductDto;
import nl.novi.zaligijsfeest.exception.RecordNotFoundException;
import nl.novi.zaligijsfeest.model.Product;
import nl.novi.zaligijsfeest.repository.ProductRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    public ProductServiceImpl(@Lazy ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

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

    @Override
    public ProductDto addProduct(ProductDto dto) {
        Product product = transferToProduct(dto);
        productRepository.save(product);
        return dto;
    }

    public Product transferToProduct(ProductDto dto) {
        var product = new Product();

        product.setId(dto.getId());
        product.setProductName(dto.getProductName());
        product.setNumberOfPersonsOne(dto.getNumberOfPersonsOne());
        product.setNumberOfPersonsTwo(dto.getNumberOfPersonsTwo());
        product.setNumberOfPersonsThree(dto.getNumberOfPersonsThree());
        product.setPriceOne(dto.getPriceOne());
        product.setPriceTwo(dto.getPriceTwo());
        product.setPriceThree(dto.getPriceThree());

        return product;
    }

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
