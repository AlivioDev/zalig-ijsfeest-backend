package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.ProductDto;
import nl.novi.zaligijsfeest.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping(path = "")
    public ResponseEntity<Object> getProducts() {
        List<ProductDto> productDtoList = productService.getProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
        ProductDto product = productService.addProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

}
