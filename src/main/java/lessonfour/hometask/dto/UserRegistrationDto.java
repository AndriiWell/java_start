package lessonfour.hometask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

@ToString
@Getter
@AllArgsConstructor
public class UserRegistrationDto {
    private String email;
    /**
     * As field better to not create Optional, but in borders of the task I decided that possible when phone is not set
     * at all, not empty field - just not set - no field on Form, but here the field is present....
     * I decided not to change because need to rewrite tests(Lots of actions), but ny idea is possible....
     * IMPORTANT: DO not use Optional as field of class!!!
     * AVOID using optional as a field!
     */
    private Optional<String> phoneNumber;
    private String password;
    private String repeatPassword;
}
