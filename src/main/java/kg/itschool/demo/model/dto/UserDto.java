package kg.itschool.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.itschool.demo.model.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String username;
    List<AccountDto> accounts;
    Role role;

    @JsonIgnore
    String password;
}
