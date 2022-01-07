package kg.itschool.demo.mapper;

import kg.itschool.demo.model.dto.AccountDto;
import kg.itschool.demo.model.entity.Account;
import org.mapstruct.factory.Mappers;

public interface AccountMapper extends BaseMapper<Account, AccountDto> {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
}
