package nl.novi.zaligijsfeest.controller;

import nl.novi.zaligijsfeest.ZaligIjsfeestApplication;
import nl.novi.zaligijsfeest.dto.UserDto;
import nl.novi.zaligijsfeest.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ContextConfiguration(classes={ZaligIjsfeestApplication.class})
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService mockService;


    @Test
    void testEndpointAddUser() throws Exception {

        UserDto mockUser = new UserDto("user01");

        Mockito.when(mockService.addUser(mockUser)).thenReturn(mockUser);

        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"username\"}")
                        .with(csrf())
                )
                .andExpect(status().isCreated());

        verify(mockService).addUser(any(UserDto.class));

    }
}