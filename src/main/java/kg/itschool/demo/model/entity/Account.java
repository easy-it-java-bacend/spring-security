package kg.itschool.demo.model.entity;

<<<<<<< HEAD
import lombok.*;
import lombok.experimental.FieldDefaults;
=======
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractAuditable;
>>>>>>> d08f0d3ab3b8d323ef01afdb15ec56b6c5a24530

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
<<<<<<< HEAD
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
=======
@NoArgsConstructor
>>>>>>> d08f0d3ab3b8d323ef01afdb15ec56b6c5a24530
@Table(name = "tb_account")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account extends AbstractAuditable<User, Long> {

    @Column(name = "account_name", nullable = false)
    String accountName;

    @Column(name = "notes", nullable = true)
    String notes;

    @Column(name = "available_money", nullable = false)
    BigDecimal availableMoney;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    User user;

    @OneToMany
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    List<Transaction> transactions;


}
