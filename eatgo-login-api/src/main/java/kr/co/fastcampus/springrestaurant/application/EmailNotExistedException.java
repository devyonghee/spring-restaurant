package kr.co.fastcampus.springrestaurant.application;

public class EmailNotExistedException extends RuntimeException {

    EmailNotExistedException(String email) {
        super("Email si not registered:" + email);
    }
}
