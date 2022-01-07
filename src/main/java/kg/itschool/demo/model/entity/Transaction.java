package kg.itschool.demo.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "tb_transaction")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    Long id;

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
