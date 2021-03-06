package kg.itschool.demo.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {
    Long id;
    String accountName;
    String notes;
    BigDecimal availableMoney;
    UserDto userDto;
    List<TransactionDto> transactions;
}
