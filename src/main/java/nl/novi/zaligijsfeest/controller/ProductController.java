package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.dto.ProductDto;
import nl.novi.zaligijsfeest.model.Product;
import nl.novi.zaligijsfeest.repository.ProductRepository;
import nl.novi.zaligijsfeest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/open")
public class ProductController {

    //koppeling met de servicelaag om de methoden te kunnen gebruiken
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;
    
    //een GET-request voor alle ijstaarten
    @GetMapping(path = "/products")
    public ResponseEntity<Object> getProducts() {
        List<ProductDto> productDtoList = productService.getProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    //een GET-request voor 1 ijstaart
    @GetMapping(path = "/products/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id) {
        ProductDto productDto = productService.getProductById(id);
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    //een POST-request voor 1 ijstaart
    @PostMapping("/products")
    public ResponseEntity<Object> addProduct(@RequestBody ProductDto productDto) {
        ProductDto product = productService.addProduct(productDto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }



    //een DELETE-request voor 1 ijstaart
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product verwijderd", HttpStatus.FOUND);
    }

    //een PUT-request voor 1 ijstaart
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        ProductDto product = productService.updateProduct(id, productDto);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}
