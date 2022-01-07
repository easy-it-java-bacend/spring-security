package kg.itschool.demo.service;

import kg.itschool.demo.model.dto.TransactionDto;
import kg.itschool.demo.model.request.CreateTransactionRequest;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    TransactionDto create(CreateTransactionRequest createTransactionRequest);
}
