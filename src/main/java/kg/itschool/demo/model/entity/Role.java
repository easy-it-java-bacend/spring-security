package kg.itschool.demo.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_role")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends AbstractPersistable<Long> {

    @Column(name = "role_name", nullable = false)
    String roleName;

    @ElementCollection
    @CollectionTable(name = "roles_has_authorities", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "authorities_id")
    List<Authority> authorities;
}
