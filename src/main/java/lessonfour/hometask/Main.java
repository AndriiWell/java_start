package lessonfour.hometask;

import lessonfour.hometask.dto.UserRegistrationDto;
import lessonfour.hometask.dto.UserResponseDto;
import lessonfour.hometask.repository.UserRepository;
import lessonfour.hometask.repository.impl.UserRepositoryImpl;
import lessonfour.hometask.service.impl.UserServiceImpl;
import lessonfour.hometask.validation.UserValidator;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        UserValidator validator = new UserValidator();
        UserRepository userRepository = new UserRepositoryImpl();
        UserServiceImpl userService = new UserServiceImpl(validator, userRepository);

        // Save operations.
        UserResponseDto userResponseDto = userService.registerUser(
            new UserRegistrationDto("elon@ma.rks", Optional.of("+6645454545"), "", "")
        );
        System.out.println(userResponseDto.toString());

        UserResponseDto userResponseDtoA = userService.registerUser(
            new UserRegistrationDto("elon@ma3.rks", Optional.of("+66454545454545"), "", "")
        );
        System.out.println(userResponseDtoA.toString());

        UserResponseDto userResponseDtoD = userService.registerUser(
            new UserRegistrationDto("elon@", Optional.of("+66"), "", "")
        );
        System.out.println(userResponseDtoD.toString());

        UserResponseDto userResponseDtoE = userService.registerUser(
            new UserRegistrationDto("elon@ma.rks", Optional.empty(), "43", "43")
        );
        System.out.println(userResponseDtoE.toString());

        UserResponseDto userResponseDtoF = userService.registerUser(
            new UserRegistrationDto("elon@ma.rks", Optional.of("66454545454545"), "43", "43")
        );
        System.out.println(userResponseDtoF.toString());

        // Find operations.
        UserResponseDto userResponseDtoB = userService.getUserById(userResponseDto.id());
        System.out.println(userResponseDtoB.toString());

        UserResponseDto userResponseDtoC = userService.getUserById(1_11111_1111_111L);
        System.out.println(userResponseDtoC.toString());
    }
}
