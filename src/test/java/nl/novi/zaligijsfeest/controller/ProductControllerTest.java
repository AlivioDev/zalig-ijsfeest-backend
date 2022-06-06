package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.ZaligIjsfeestApplication;
import nl.novi.zaligijsfeest.dto.ProductDto;
import nl.novi.zaligijsfeest.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@ContextConfiguration(classes={ZaligIjsfeestApplication.class})
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService mockProductService;

    @Test
    void testEndpointGetProducts() throws Exception {
        ProductDto mockProduct = new ProductDto(1007L, "Bombe", "3/4 personen", 19.50);
        List<ProductDto> mockList = List.of(mockProduct);

        given(mockProductService.getProducts()).willReturn(mockList);

        mockMvc.perform(get("/products"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].productName", is("Bombe")));
    }

    @Test
    void testEndpointGetProductById() throws Exception {
        when(mockProductService.getProductById(1007L))
                .thenReturn(new ProductDto(1007L, "Bombe", "3/4 personen", 19.50));

        mockMvc.perform(get("/products/1007")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"1007\", \"productName\": \"Bombe\", \"numberOfPersonsOne\": \"3/4 personen\", \"priceOne\":\"19.50\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productName", is("Bombe")));
    }

    @Test
    void testEndpointAddProduct() throws Exception {

        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"1007\", \"productName\": \"Bombe\", \"numberOfPersonsOne\": \"3/4 personen\", \"priceOne\":\"19.50\"}")
        )
                .andExpect(status().isCreated());

        verify(mockProductService).addProduct(any(ProductDto.class));
    }
}