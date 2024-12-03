package lessonfour.hometask.service.impl.userserviceimpl;

import lessonfour.hometask.dto.UserRegistrationDto;
import lessonfour.hometask.dto.UserResponseDto;
import lessonfour.hometask.exception.DatabaseException;
import lessonfour.hometask.exception.UserRegistrationDtoException;
import lessonfour.hometask.model.User;
import lessonfour.hometask.repository.UserRepository;
import lessonfour.hometask.service.impl.UserServiceImpl;
import lessonfour.hometask.validation.UserValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Unit tests for UserServiceImpl class registerUser method")
@ExtendWith(MockitoExtension.class)
class RegisterUserTest {
    @Mock
    private UserRepository userRepository; // Mock for tested class dependency.

    @Mock
    private UserValidator userValidator; // Mock for tested class dependency.

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void registerUser_WithValidRegistrationDto_ShouldReturnValidResponseDto() {
        Long userId = 1L;
        String email = "valid@mail.com";
        String phone = "+123456789";
        String pass = "Passw";

        // Input data.
        UserRegistrationDto registrationDto = new UserRegistrationDto(
            email,
            Optional.of(phone),
            pass,
            pass
        );
        // Data after saving.
        User userPostSave = new User(
                userId,
                registrationDto.getEmail(),
                registrationDto.getPhoneNumber().orElse(""),
                registrationDto.getPassword()
        );
        // Validator just set but does nothing.
        Mockito.doNothing().when(userValidator).validate(registrationDto);
        // Just to mock saving operation. User saved and returned.
        when(userRepository.save(any(User.class))).thenReturn(userPostSave);
        // After mocking all dependencies I can register user, - action of this test.
        UserResponseDto responseDto = userService.registerUser(registrationDto);

        assertEquals(userId, responseDto.id());
        assertEquals(email, responseDto.email());
        assertTrue(responseDto.hasPhone());
        assertTrue(responseDto.isStored());
        verify(userValidator, times(1)).validate(registrationDto);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @DisplayName("Verify the returned failed response dto instance when invalid registration data is provided, no save method call.")
    @Test
    void registerUser_WithInvalidRegistrationDto_ShouldReturnFailedResponseDto() {
        Long userId = 0L;
        String email = "invalid.mail.com@";
        String phone = "+123456789";
        String pass = "Passw";

        UserRegistrationDto invalidRegistrationDto = new UserRegistrationDto(
            email,
            Optional.of(phone),
            pass,
            pass
        );

        // Imitate an exception during validation.
        doThrow(new UserRegistrationDtoException("Email has invalid format."))
            .when(userValidator).validate(invalidRegistrationDto);

        UserResponseDto responseDto = userService.registerUser(invalidRegistrationDto);

        assertEquals(userId, responseDto.id());
        assertEquals(email, responseDto.email());
        assertFalse(responseDto.hasPhone());
        assertFalse(responseDto.isStored());

        verify(userValidator, times(1)).validate(invalidRegistrationDto);
        // Save is no happens, because a validation error.
        verify(userRepository, times(0)).save(any(User.class));
    }

    @DisplayName("Verify some else exception instead of UserRegistrationDtoException.")
    @Test
    void registerUser_WithValidRegistrationDto_ShouldThrowException() {
        String email = "valid@mail.com";
        String phone = "+123456789";
        String pass = "Passw";

        UserRegistrationDto registrationDto = new UserRegistrationDto(
            email,
            Optional.of(phone),
            pass,
            pass
        );

        doThrow(new RuntimeException("Unexpected error...")).when(userValidator).validate(registrationDto);

        RuntimeException exception = assertThrows(RuntimeException.class,() -> userService.registerUser(
            registrationDto
        ));

        assertEquals("Unexpected error...", exception.getMessage());
        verify(userRepository, times(0)).save(any(User.class));
    }

    @DisplayName("Verify that user with empty phone is valid and registration passed with calling method save.")
    @Test
    void registerUser_WithEmptyPhoneRegistrationDto_ShouldReturnValidResponseDto() {
        Long userId = 234_343_322_000_000_001L;
        String email = "invalid.mail.com@";
        String pass = "Passw";

        UserRegistrationDto registrationDto = new UserRegistrationDto(
            email,
            Optional.empty(), // Check for the empty phone below.
            pass,
            pass
        );
        // Data after saving.
        User userPostSave = new User(
            userId,
            registrationDto.getEmail(),
            registrationDto.getPhoneNumber().orElse(""),
            registrationDto.getPassword()
        );
        // Validator just set but does nothing.
        Mockito.doNothing().when(userValidator).validate(registrationDto);
        // Just to mock saving operation. User saved and returned.
        when(userRepository.save(any(User.class))).thenReturn(userPostSave);
        // After mocking all dependencies I can register user, - action of this test.
        UserResponseDto responseDto = userService.registerUser(registrationDto);

        assertEquals(userId, responseDto.id());
        assertEquals(email, responseDto.email());
        assertFalse(responseDto.hasPhone());
        assertTrue(responseDto.isStored());
        verify(userValidator, times(1)).validate(registrationDto);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @DisplayName("Verify when an exception was thrown during data saving.")
    @Test
    void registerUser_UserRepositoryThrowsException_ShouldThrowException() {
        when(userRepository.save(any(User.class))).thenThrow(new DatabaseException("Bida"));
        DatabaseException exception = assertThrows(DatabaseException.class,() -> userService.registerUser(
            new UserRegistrationDto("any", Optional.of("any"), "any", "any"))
        );

        assertEquals("Bida", exception.getMessage());
        verify(userRepository, times(1)).save(any(User.class));
    }
}