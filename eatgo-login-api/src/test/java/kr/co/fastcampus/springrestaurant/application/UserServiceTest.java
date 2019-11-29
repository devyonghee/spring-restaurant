package kr.co.fastcampus.springrestaurant.application;

import kr.co.fastcampus.springrestaurant.domain.User;
import kr.co.fastcampus.springrestaurant.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class UserServiceTest {
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository, passwordEncoder);
    }

    @Test
    void authenticateWithValidAttributes() {
        String email = "tester@example.com";
        String password = "test";

        User mockUser = User.builder().email(email).build();
        given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));
        given(passwordEncoder.matches(any(), any())).willReturn(true);

        User user = userService.authenticate(email, password);

        assertEquals(email, user.getEmail());
    }

    @Test
    void authenticateWithNotExistedEmail() {
        String email = "tester@example.com";
        String password = "test";

        given(userRepository.findByEmail(email)).willReturn(Optional.empty());
        assertThrows(EmailNotExistedException.class, () -> userService.authenticate(email, password));
    }

    @Test
    void authenticateWithWrongPassword() {
        String email = "tester@example.com";
        String password = "x";

        User mockUser = User.builder().email(email).build();
        given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));
        given(passwordEncoder.matches(any(), any())).willReturn(false);

        assertThrows(PasswordWrongException.class, () -> userService.authenticate(email, password));
    }
}