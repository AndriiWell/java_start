package lessonfour.hometask.service.impl;

import lessonfour.hometask.dto.UserRegistrationDto;
import lessonfour.hometask.dto.UserResponseDto;
import lessonfour.hometask.exception.ValidationException;
import lessonfour.hometask.model.User;
import lessonfour.hometask.repository.UserRepository;
import lessonfour.hometask.service.UserService;
import lessonfour.hometask.validation.UserValidator;

public class UserServiceImpl implements UserService {
    private final UserValidator validator;
    private final UserRepository userRepository;

    public UserServiceImpl(UserValidator validator, UserRepository userRepository) {
        this.validator = validator;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
        try {
            validator.validate(userRegistrationDto);

            User user = new User(
                null,
                userRegistrationDto.getEmail(),
                userRegistrationDto.getPhoneNumber().orElse(""),
                userRegistrationDto.getPassword()
            );
            user = userRepository.save(user);
            return new UserResponseDto(user.getId(), user.getEmail(), true, userRegistrationDto.getPhoneNumber().isPresent());
        } catch (ValidationException e) {
            System.err.println("Validation was failed for input data: " + userRegistrationDto.toString() + ", error: " + e.getMessage());
            return new UserResponseDto(0L, userRegistrationDto.getEmail(), false, false); // Empty!
        }
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        return userRepository.findById(userId).map(user -> new UserResponseDto(user.getId(), user.getEmail(), true, !user.getPhone().isEmpty()))
            .orElse(new UserResponseDto(userId, "", false, false));
    }
}
