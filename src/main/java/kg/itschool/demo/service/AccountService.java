package kg.itschool.demo.service;

import kg.itschool.demo.model.dto.AccountDto;
import kg.itschool.demo.model.request.CreateAccountRequest;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    AccountDto create(CreateAccountRequest createAccountRequest);
    AccountDto getById(Long id);
    AccountDto create(AccountDto accountDto);
    AccountDto update(AccountDto accountDo);
}
