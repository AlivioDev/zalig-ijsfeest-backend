package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.ZaligIjsfeestApplication;
import nl.novi.zaligijsfeest.dto.OrderDto;
import nl.novi.zaligijsfeest.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
@ContextConfiguration(classes={ZaligIjsfeestApplication.class})
class OrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrderService mockService;

    @Test
    void testGetOrdersByUserUsername() throws Exception {
        OrderDto mockOrder = new OrderDto(25.00, "online");
        List<OrderDto> mockList = List.of(mockOrder);

        Mockito.when(mockService.findOrdersByUserUsername("user01")).thenReturn(mockList);

        mockMvc.perform(get("/orders/user/user01"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("online")));

    }

    @Test
    void testCreateOrder() throws Exception {
        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orderAmount\": \"25.00\", \"paymentStatus\": \"online\"}")
                )
                .andExpect(status().isCreated());

        verify(mockService).addOrder(any(OrderDto.class));
    }
}