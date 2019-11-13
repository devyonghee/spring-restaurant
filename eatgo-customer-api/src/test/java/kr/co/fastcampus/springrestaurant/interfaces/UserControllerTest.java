package kr.co.fastcampus.springrestaurant.interfaces;

import kr.co.fastcampus.springrestaurant.application.ReviewService;
import kr.co.fastcampus.springrestaurant.application.UserService;
import kr.co.fastcampus.springrestaurant.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @Test
    void create() throws Exception {

        User mockUser = User.builder()
                .id(1004L)
                .email("tester@example.com")
                .name("Tester")
                .password("test")
                .build();

        given(userService.registerUser("tester@example.com", "Tester", "test")).willReturn(mockUser);

        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Tester\",\"email\": \"tester@example.com\",\"password\":\"test\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("location", "/users/1004"));

        verify(userService).registerUser(
                eq("tester@example.com"), eq("Tester"), eq("test")
        );
    }

}