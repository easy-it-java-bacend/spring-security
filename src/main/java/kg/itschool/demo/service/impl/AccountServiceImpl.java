package kg.itschool.demo.service.impl;

import kg.itschool.demo.mapper.AccountMapper;
import kg.itschool.demo.mapper.UserMapper;
import kg.itschool.demo.model.dto.AccountDto;
import kg.itschool.demo.model.dto.UserDto;
import kg.itschool.demo.model.entity.Account;
import kg.itschool.demo.model.request.CreateAccountRequest;
import kg.itschool.demo.repository.AccountRepository;
import kg.itschool.demo.service.AccountService;
import kg.itschool.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private UserService userService;

    @Override
    public AccountDto create(CreateAccountRequest createAccountRequest) {

        UserDto userDto = userService.findById(createAccountRequest.getUserId());

        Account account = Account
                .builder()
                .accountName(createAccountRequest.getAccountName())
                .availableMoney(createAccountRequest.getAvailableMoney())
                .notes(createAccountRequest.getNotes())
                .user(UserMapper.INSTANCE.toEntity(userDto))
                .build();

        accountRepository.save(account);

        return AccountMapper.INSTANCE.toDto(account);
    }

    @Override
    public AccountDto getById(Long id) {
        return AccountMapper.INSTANCE.toDto(accountRepository.findById(id).orElseThrow(() -> new RuntimeException("account not found")));
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        return AccountMapper.INSTANCE.toDto(accountRepository.save(AccountMapper.INSTANCE.toEntity(accountDto)));
    }

    @Override
    public AccountDto update(AccountDto accountDto) {
        Account accountEntity = accountRepository.findById(accountDto.getId())
                .map(account -> {
                    account.setAvailableMoney(accountDto.getAvailableMoney());
                    return accountRepository.save(account);
                })
                .orElseThrow(() -> new RuntimeException("account not found"));
        return AccountMapper.INSTANCE.toDto(accountEntity);
    }
}
