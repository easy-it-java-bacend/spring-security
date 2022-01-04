package kg.itschool.demo.model.request;

import kg.itschool.demo.model.entity.Role;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateUserRequest {
    String username;
    String firstName;
    String lastName;
    String email;
    String password;
    Role role;
}
