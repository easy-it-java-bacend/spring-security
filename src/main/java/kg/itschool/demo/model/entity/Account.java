package kg.itschool.demo.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false,unique = true)
    Long id;

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
