package kg.itschool.demo.model.dto;

import kg.itschool.demo.model.entity.Authority;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleDto {
    Long id;
    String roleName;
    List<String> authorities;
}
