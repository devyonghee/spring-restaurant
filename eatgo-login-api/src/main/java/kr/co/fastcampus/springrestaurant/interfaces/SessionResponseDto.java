package kr.co.fastcampus.springrestaurant.interfaces;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionResponseDto {
    private String accessToken;
}
