package kr.co.fastcampus.springrestaurant.interfaces;

import lombok.Data;

@Data
public class SessionRequestDto {
    private String email;
    private String password;
}
