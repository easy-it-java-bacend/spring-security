package kg.itschool.demo.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_role")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

    @Id
    @Column(name = "id", nullable = false)
    Long id;

    @Column(name = "role_name", nullable = false)
    String roleName;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    List<Authority> authorities;
}
