package kr.co.fastcampus.springrestaurant.application;

import kr.co.fastcampus.springrestaurant.domain.User;
import kr.co.fastcampus.springrestaurant.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String email, String name, String password) {
        Optional<User> existed = userRepository.findByEmail(email);

        if (existed.isPresent()) {
            throw new EmailExistedException(email);
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);
        User user = User.builder()
                .email(email)
                .name(name)
                .password(encodedPassword)
                .level(1L)
                .build();
        return userRepository.save(user);
    }
}
