package kg.itschool.demo.service.impl;

import kg.itschool.demo.mapper.AccountMapper;
import kg.itschool.demo.mapper.TransactionMapper;
import kg.itschool.demo.model.dto.AccountDto;
import kg.itschool.demo.model.dto.TransactionDto;
import kg.itschool.demo.model.entity.Account;
import kg.itschool.demo.model.entity.Transaction;
import kg.itschool.demo.model.entity.User;
import kg.itschool.demo.model.request.CreateTransactionRequest;
import kg.itschool.demo.repository.TransactionRepository;
import kg.itschool.demo.repository.UserRepository;
import kg.itschool.demo.service.AccountService;
import kg.itschool.demo.service.TransactionService;
import kg.itschool.demo.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    final TransactionRepository transactionRepository;
    final AccountService accountService;

    @Override
    public TransactionDto create(CreateTransactionRequest createTransactionRequest) {
        //Вытаскиваем аккаунты из аккаунт сервиса, по id-шникам которые находятся в createTransactionRequest
        AccountDto accountFrom = accountService.getById(createTransactionRequest.getAccountFromId());
        AccountDto accountTo = accountService.getById(createTransactionRequest.getAccountToId());

        //Проверяем на наличие достаточного количества денег на счету отправителя
        if(accountFrom.getAvailableMoney().doubleValue() < createTransactionRequest.getAmount().doubleValue()) {
            throw new RuntimeException("Transaction not acceptable");
        }

        Transaction transaction = Transaction.builder()
                .amount(createTransactionRequest.getAmount())
                .purpose(createTransactionRequest.getPurpose())
                .notes(createTransactionRequest.getNotes())
                .accountFrom(AccountMapper.INSTANCE.toEntity(accountFrom))
                .accountTo(AccountMapper.INSTANCE.toEntity(accountTo))
                .build();

        //Снимаем деньги(getAmount) у счета отпрвителя
        accountFrom.setAvailableMoney(BigDecimal.valueOf(accountFrom.getAvailableMoney().doubleValue()
                - createTransactionRequest.getAmount().doubleValue()));

        //Добавляем деньги(getAmount) на счет получателя
        accountTo.setAvailableMoney(BigDecimal.valueOf(accountTo.getAvailableMoney().doubleValue()
                + createTransactionRequest.getAmount().doubleValue()));

        //Сохраняем измененные кошельки
        accountService.update(accountFrom);
        accountService.update(accountTo);

        //Сохраняем транзакцию
        transactionRepository.save(transaction);

        return TransactionMapper.INSTANCE.toDto(transaction);
    }


}
