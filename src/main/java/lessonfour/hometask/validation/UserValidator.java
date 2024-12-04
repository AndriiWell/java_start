package lessonfour.hometask.validation;

import lessonfour.hometask.dto.UserRegistrationDto;
import lessonfour.hometask.exception.ValidationException;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class UserValidator {
    public void validate(UserRegistrationDto userRegistrationDto) {
        validateEmail(userRegistrationDto.getEmail());
        validatePhone(userRegistrationDto.getPhoneNumber());
        validatePassword(userRegistrationDto.getPassword(), userRegistrationDto.getRepeatPassword());
    }

    private void validateEmail(String email) {
        if (null == email || email.isBlank() || email.length() > 50) {
            throw new ValidationException("Email has wrong length.");
        }

        int atIndex = email.indexOf('@');
        int pointIndex = email.indexOf('.');

        if (atIndex < 1 || pointIndex < atIndex + 2 || email.length() - 2 < pointIndex) {
            throw new ValidationException("Email has invalid format.");
        }
    }

    private void validatePassword(String password, String repeatPassword) {
        if (password == null || repeatPassword == null) {
            throw new ValidationException("Passwords cannot be empty.");
        } else if (!password.equals(repeatPassword)) {
            throw new ValidationException("Passwords are not equal.");
        }
    }

    private void validatePhone(Optional<String> phone) {
        phone.ifPresent(value -> {
            if (value.length() > 20 || value.length() < 9) {
                throw new ValidationException("Phone length is wrong.");
            } else if (value.indexOf('+') != 0) {
                throw new ValidationException("Maybe you missed country code, starts since + symbol.");
            }
        });
    }
}
