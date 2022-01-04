package kg.itschool.demo.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    Long id;

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
