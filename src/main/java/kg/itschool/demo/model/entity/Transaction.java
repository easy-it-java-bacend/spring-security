package kg.itschool.demo.model.entity;

<<<<<<< HEAD
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
=======
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;
>>>>>>> d08f0d3ab3b8d323ef01afdb15ec56b6c5a24530

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

<<<<<<< HEAD

=======
>>>>>>> d08f0d3ab3b8d323ef01afdb15ec56b6c5a24530
@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_transaction")
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    Long id;
=======
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction extends AbstractPersistable<Long> {
>>>>>>> d08f0d3ab3b8d323ef01afdb15ec56b6c5a24530

    @CreationTimestamp
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
    Account accountTo;

    @ManyToOne
    @JoinColumn(name = "account_from_id", referencedColumnName = "id")
    Account accountFrom;
}
