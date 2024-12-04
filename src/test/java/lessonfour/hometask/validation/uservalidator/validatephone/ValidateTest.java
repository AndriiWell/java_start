package lessonfour.hometask.validation.uservalidator.validatephone;

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

    @DisplayName("Validate correct phone when it set.")
    @Test
    void validate_ValidPhone_ShouldPass() {
        assertDoesNotThrow(() -> userValidator.validate(new UserRegistrationDto(
            "valid@mail.com",
            Optional.of("+"+"3".repeat(10)),
            "",
            ""
        )));
    }

    @DisplayName("Validate when no set phone.")
    @Test
    void validate_ValidNoPhone_ShouldThrowException() {
        // arrange & act & assert
        assertDoesNotThrow(() -> userValidator.validate(new UserRegistrationDto(
            "valid@mail.com",
            Optional.empty(),
            "",
            ""
        )));
    }

    @DisplayName("Validate throw exception when phone passed but as empty string.")
    @Test
    void validate_InvalidEmptyPhone_ShouldThrowException() {
        // arrange & act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.of(""),
                "",
                ""
            ))
        );

        // assert
        assertEquals("Phone length is wrong.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when phone too short.")
    @Test
    void validate_InvalidShortPhone_ShouldThrowException() {
        // arrange & act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.of("1".repeat(8)),
                "",
                ""
            ))
        );

        // assert
        assertEquals("Phone length is wrong.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when phone too long.")
    @Test
    void validate_InvalidLongPhone_ShouldThrowException() {
        // arrange & act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.of("1".repeat(21)),
                "",
                ""
            ))
        );

        // assert
        assertEquals("Phone length is wrong.", exception.getMessage());
    }

    @DisplayName("Validate throw exception when phone starts not from + symbol.")
    @Test
    void validate_InvalidPhoneCode_ShouldThrowException() {
        // arrange & act
        ValidationException exception = assertThrows(ValidationException.class,
            () -> userValidator.validate(new UserRegistrationDto(
                "valid@mail.com",
                Optional.of("1".repeat(20)),
                "",
                ""
            ))
        );

        // assert
        assertEquals("Maybe you missed country code, starts since + symbol.", exception.getMessage());
    }
}
