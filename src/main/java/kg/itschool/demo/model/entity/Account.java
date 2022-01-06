package kg.itschool.demo.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_account")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account extends AbstractAuditable<User, Long> {

    @Column(name = "account_name", nullable = false)
    String accountName;

    @Column(name = "notes", nullable = true)
    String notes;

    @Column(name = "available_money", nullable = false)
    Long availableMoney;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    User  user;

    @OneToMany
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    List<Transaction> transactions;


}
