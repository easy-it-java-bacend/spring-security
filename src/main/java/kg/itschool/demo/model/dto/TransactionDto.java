package kg.itschool.demo.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto {
    Long id;
    LocalDate transactionDate;
    String purpose;
    BigDecimal amount;
    String notes;
    Long accountToID;
    Long accountFromId;
}
