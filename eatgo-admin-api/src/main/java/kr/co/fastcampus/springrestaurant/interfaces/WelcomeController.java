package kr.co.fastcampus.springrestaurant.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String  hello() {
        return "hello world";
    }
}
