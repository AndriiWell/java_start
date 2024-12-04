package lessonfour.hometask.validation.uservalidator.validatepassword;

import lessonfour.hometask.dto.UserRegistrationDto;
import lessonfour.hometask.exception.ValidationException;
import lessonfour.hometask.validation.UserValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "valid@mail.com",
            Optional.empty(),
            "",
            ""
        );

        // act
        assertDoesNotThrow(() -> userValidator.validate(registrationDto));

        // assert
    }

    @DisplayName("Validate throw exception when password or repeated password are null.")
    @Test
    void validate_NullPassword_ShouldThrowException() {
        // arrange & act
        ValidationException exceptionA = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                null,
                ""
            ))
        );
        ValidationException exceptionB = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                "",
                null
            ))
        );
        ValidationException exceptionC = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                null,
                null
            ))
        );

        // assert
        assertEquals("Passwords cannot be empty.", exceptionA.getMessage());
        assertEquals("Passwords cannot be empty.", exceptionB.getMessage());
        assertEquals("Passwords cannot be empty.", exceptionC.getMessage());
    }

    @DisplayName("Validate throw exception when password not equal repeated password.")
    @Test
    void validate_PasswordNotEqualRepeatPassword_ShouldThrowException() {
        // arrange & act
        ValidationException exceptionA = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                "1",
                ""
            ))
        );
        ValidationException exceptionB = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.empty(),
                "Pp",
                "pp"
            ))
        );

        // assert
        assertEquals("Passwords are not equal.", exceptionA.getMessage());
        assertEquals("Passwords are not equal.", exceptionB.getMessage());
    }
}
