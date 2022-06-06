package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.ZaligIjsfeestApplication;
import nl.novi.zaligijsfeest.dto.OrderLineDto;
import nl.novi.zaligijsfeest.service.OrderLineService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(OrderLineController.class)
@ContextConfiguration(classes={ZaligIjsfeestApplication.class})
class OrderLineControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderLineService mockOrderLineService;


    @Test
    void testEndpointGetOrderLines() throws Exception {
        OrderLineDto mockOrderLine = new OrderLineDto("user01", "IJstaart Rond", "banaan", "4/6 personen", 20.00);
        List<OrderLineDto> allOrderLines = List.of(mockOrderLine);

        given(mockOrderLineService.findOrderLines()).willReturn(allOrderLines);

        mockMvc.perform(get("/orderlines"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].productName", is("IJstaart Rond")));
    }

    @Test
    void testEndpointGetOrderLinesByUser() throws Exception {
        OrderLineDto mockOrderLine = new OrderLineDto("user01", "IJstaart Rond", "banaan", "4/6 personen", 20.00);
        List<OrderLineDto> mockOrderLineList = List.of(mockOrderLine);

        Mockito.when(mockOrderLineService.findOrderLinesByUsername("user01"))
                .thenReturn(mockOrderLineList);

        mockMvc.perform(get("/orderlines/user/user01")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"user01\", \"productName\": \"IJstaart Rond\", \"flavors\": \"banaan\", \"options\": \"4/6 personen\", \"price\":\"20.00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].productName", is("IJstaart Rond")));
    }

    @Test
    void testEndpointCreateOrderLine() throws Exception {
        mockMvc.perform(post("/orderlines")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": \"user01\", \"productName\": \"IJstaart Rond\", \"flavors\": \"banaan\", \"options\": \"4/6 personen\", \"price\":\"20.00\"}")
                )
                .andExpect(status().isCreated());

        verify(mockOrderLineService).addOrderLine(any(OrderLineDto.class));
    }

}