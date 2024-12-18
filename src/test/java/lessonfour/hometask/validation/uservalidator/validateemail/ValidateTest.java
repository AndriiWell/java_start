package lessonfour.hometask.validation.uservalidator.validateemail;

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

    @DisplayName("Validate correct email.")
    @Test
    void validate_ValidEmail_ShouldPass() {
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

    @DisplayName("Validate throw exception when email is null.")
    @Test
    void validate_NullEmail_ShouldThrowException() {
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            null,
            Optional.empty(),
            "",
            ""
        );

        // act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(registrationDto));

        // assert
        assertEquals("Email has wrong length.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when email is empty.")
    @Test
    void validate_EmptyEmail_ShouldThrowException() {
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "",
            Optional.empty(),
            "",
            ""
        );

        // act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(registrationDto));

        // assert
        assertEquals("Email has wrong length.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when email is too long.")
    @Test
    void validate_LongEmail_ShouldThrowException() {
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "e".repeat(51), // More than 50 symbols.
            Optional.empty(),
            "",
            ""
        );

        // act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(registrationDto));

        // assert
        assertEquals("Email has wrong length.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when no dot.")
    @Test
    void validate_NoDotEmail_ShouldThrowException() {
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "emai@lcom",
            Optional.empty(),
            "",
            ""
        );

        // act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(registrationDto));

        // assert
        assertEquals("Email has invalid format.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when dot before @ symbol.")
    @Test
    void validate_EarlyDotEmail_ShouldThrowException() {
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "ema.i@lcom",
            Optional.empty(),
            "",
            ""
        );

        // act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(registrationDto));

        // assert
        assertEquals("Email has invalid format.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when no @ symbol.")
    @Test
    void validate_NoAtEmail_ShouldThrowException() {
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "emaillove.com",
            Optional.empty(),
            "",
            ""
        );

        // act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(registrationDto));

        // assert
        assertEquals("Email has invalid format.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when @ symbol too early.")
    @Test
    void validate_EarlyAtEmail_ShouldThrowException() {
        // arrange
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            "@emaillove.com",
            Optional.empty(),
            "",
            ""
        );

        // act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(registrationDto));

        // assert
        assertEquals("Email has invalid format.", exception.getMessage());
    }
}
