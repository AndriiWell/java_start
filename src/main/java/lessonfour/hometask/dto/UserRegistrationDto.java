package lessonfour.hometask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@ToString
@Getter
@AllArgsConstructor
public class UserRegistrationDto {
    private String email;
    private Optional<String> phoneNumber;
    private String password;
    private String repeatPassword;
}
