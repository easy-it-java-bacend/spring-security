package kg.itschool.demo.model.request;

import kg.itschool.demo.model.dto.TransactionDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CreateAccountRequest {
    String accountName;
    String notes;
    BigDecimal availableMoney;
    Long userId;
    List<TransactionDto> transactions;
}
