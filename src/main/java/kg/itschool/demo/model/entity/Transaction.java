package kg.itschool.demo.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_transaction")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction extends AbstractPersistable<Long> {

    @Column(name = "transaction_date", nullable = false)
    LocalDateTime transactionDate;

    @Column(name = "purpose", nullable = false)
    String purpose;

    @Column(name = "amount", nullable = false)
    BigDecimal amount;

    @Column(name = "notes", nullable = true)
    String notes;

    @ManyToOne
    @JoinColumn(name = "account_to_id", referencedColumnName = "id")
    Account accountToId;

    @ManyToOne
    @JoinColumn(name = "account_from_id", referencedColumnName = "id")
    Account accountFromId;
}
