package nl.novi.zaligijsfeest.Service;

import nl.novi.zaligijsfeest.Dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();
    ProductDto getProductById(Long id);
    ProductDto addProduct(ProductDto dto);
    void deleteProduct(Long id);
    ProductDto updateProduct(Long id, ProductDto dto);
}
