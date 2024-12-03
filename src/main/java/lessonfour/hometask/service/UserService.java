package lessonfour.hometask.service;

import lessonfour.hometask.dto.UserRegistrationDto;
import lessonfour.hometask.dto.UserResponseDto;

public interface UserService {
    UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);

    UserResponseDto getUserById(Long userId);
}
