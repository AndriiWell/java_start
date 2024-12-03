package lessonfour.hometask.validation.uservalidator.validatepassword;

import lessonfour.hometask.dto.UserRegistrationDto;
import lessonfour.hometask.exception.UserRegistrationDtoException;
import lessonfour.hometask.validation.UserValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit tests for UserValidator class validate method")
@ExtendWith(MockitoExtension.class)
class ValidateTest {
    private static UserValidator userValidator;

    @BeforeAll
    static void setUp() {
        userValidator = new UserValidator();
    }

    @DisplayName("Validate correct password.")
    @Test
    void validate_ValidPass_ShouldPass() {
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "valid@mail.com",
            Optional.empty(),
            "",
            ""
        );
        assertDoesNotThrow(() -> userValidator.validate(registrationDto));
    }

    @DisplayName("Validate throw exception when password or repeated password are null.")
    @Test
    void validate_NullPassword_ShouldThrowException() {
        UserRegistrationDtoException exception = assertThrows(UserRegistrationDtoException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                null,
                ""
            ))
        );
        assertEquals("Passwords cannot be empty.", exception.getMessage());

        exception = assertThrows(UserRegistrationDtoException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                "",
                null
            ))
        );
        assertEquals("Passwords cannot be empty.", exception.getMessage());

        exception = assertThrows(UserRegistrationDtoException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                null,
                null
            ))
        );
        assertEquals("Passwords cannot be empty.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when password not equal repeated password.")
    @Test
    void validate_PasswordNotEqualRepeatPassword_ShouldThrowException() {
        UserRegistrationDtoException exception = assertThrows(UserRegistrationDtoException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                "1",
                ""
            ))
        );
        assertEquals("Passwords are not equal.", exception.getMessage());

        exception = assertThrows(UserRegistrationDtoException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                "Pp",
                "pp"
            ))
        );
        assertEquals("Passwords are not equal.", exception.getMessage());
    }
}
