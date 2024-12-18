package lessonfour.hometask.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private String email;
    private String phone;
    private String pass;
}
