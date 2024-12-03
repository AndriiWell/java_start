package lessonfour.hometask.service.impl.userserviceimpl;

import lessonfour.hometask.dto.UserResponseDto;
import lessonfour.hometask.exception.DatabaseException;
import lessonfour.hometask.model.User;
import lessonfour.hometask.repository.UserRepository;
import lessonfour.hometask.service.impl.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("Unit tests for UserServiceImpl class getUserById method")
@ExtendWith(MockitoExtension.class)
class GetUserByIdTest {
    @Mock
    private UserRepository userRepository; // getUserById() uses only one dependency, no validator dependency.

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void getUserById_WithValidUserId_ShouldReturnValidResponseDto() {
        Long userId = 1L;
        String email = "valid@mail.com";
        String phone = "+123456789";
        String pass = "Passw";

        // To mock finding operation. Below sets: user found and returned.
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User(
            userId,
            email,
            phone,
            pass
        )));
        // After mocking all dependencies I can look for the user, - the action of this test.
        UserResponseDto responseDto = userService.getUserById(userId);

        assertEquals(userId, responseDto.id());
        assertEquals(email, responseDto.email());
        assertTrue(responseDto.hasPhone());
        assertTrue(responseDto.isStored());
        // Check that method findById was called.
        verify(userRepository, times(1)).findById(userId);
    }

    @DisplayName("Verify search for user with empty phone.")
    @Test
    void getUserById_WithValidUserIdEmptyPhone_ShouldReturnValidResponseDto() {
        Long userId = 1L;
        String email = "valid@mail.com";
        String phone = "";
        String pass = "Passw";

        // To mock finding operation. Below sets: user found and returned.
        when(userRepository.findById(userId)).thenReturn(Optional.of(new User(
            userId,
            email,
            phone,
            pass
        )));
        // After mocking all dependencies I can look for the user, - the action of this test.
        UserResponseDto responseDto = userService.getUserById(userId);

        assertEquals(userId, responseDto.id());
        assertEquals(email, responseDto.email());
        assertFalse(responseDto.hasPhone());
        assertTrue(responseDto.isStored());
        // Check that method findById was called.
        verify(userRepository, times(1)).findById(userId);
    }

    @DisplayName("Verify search for user which absent in database.")
    @Test
    void getUserById_WithInvalidUserId_ShouldReturnValidResponseDto() {
        Long userId = anyLong();

        // To mock finding operation. Below sets: user found and returned.
        when(userRepository.findById(userId)).thenReturn(Optional.empty());
        // After mocking all dependencies I can look for the user, - the action of this test.
        UserResponseDto responseDto = userService.getUserById(userId);

        assertEquals(userId, responseDto.id());
        assertEquals("", responseDto.email());
        assertFalse(responseDto.hasPhone());
        assertFalse(responseDto.isStored());
        // Check that method findById was called.
        verify(userRepository, times(1)).findById(userId);
    }

    @DisplayName("Verify when an exception was thrown during data fetching.")
    @Test
    void registerUser_UserRepositoryThrowsException_ShouldThrowException() {

        Long userId = anyLong();
        when(userRepository.findById(userId)).thenThrow(new DatabaseException("Can't find user..."));
        DatabaseException exception = assertThrows(DatabaseException.class,() -> userService.getUserById(userId));

        assertEquals("Can't find user...", exception.getMessage());
        verify(userRepository, times(1)).findById(userId);
    }
}
