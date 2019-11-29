package kr.co.fastcampus.springrestaurant.application;

public class PasswordWrongException extends RuntimeException {
    PasswordWrongException() {
        super("Password is wrong");
    }
}
