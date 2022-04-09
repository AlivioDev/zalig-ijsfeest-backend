package nl.novi.zaligijsfeest.service;

import nl.novi.zaligijsfeest.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();
    ProductDto getProductById(Long id);
    ProductDto addProduct(ProductDto dto);
    void deleteProduct(Long id);
    ProductDto updateProduct(Long id, ProductDto dto);
}
