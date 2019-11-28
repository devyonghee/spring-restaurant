package kr.co.fastcampus.springrestaurant.interfaces;

import kr.co.fastcampus.springrestaurant.application.UserService;
import kr.co.fastcampus.springrestaurant.domain.User;
import kr.co.fastcampus.springrestaurant.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    private final UserService userService;

    private final JwtUtil jwtUtil;

    @Autowired
    public SessionController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {
        String url = "/session";
        User user = userService.authenticate(resource.getEmail(), resource.getPassword());

        String accessToken = jwtUtil.createToken(user.getId(), user.getName());

        return ResponseEntity.created(new URI(url)).body(
                SessionResponseDto.builder()
                        .accessToken(accessToken)
                        .build()
        );
    }
}
