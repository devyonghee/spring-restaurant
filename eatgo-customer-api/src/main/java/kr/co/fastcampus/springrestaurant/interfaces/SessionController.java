package kr.co.fastcampus.springrestaurant.interfaces;

import kr.co.fastcampus.springrestaurant.application.UserService;
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

    @Autowired
    public SessionController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(@RequestBody SessionRequestDto resource) throws URISyntaxException {
        String url = "/session";
        String accessToken = "ACCESSTOKEN";
        userService.authenticate(resource.getEmail(), resource.getPassword());

        return ResponseEntity.created(new URI(url)).body(
                SessionResponseDto.builder()
                        .accessToken(accessToken)
                        .build()
        );
    }
}
