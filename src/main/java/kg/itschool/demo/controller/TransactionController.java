package kg.itschool.demo.controller;

import kg.itschool.demo.model.dto.TransactionDto;
import kg.itschool.demo.model.request.CreateTransactionRequest;
import kg.itschool.demo.service.TransactionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    final TransactionService transactionService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('TRANSACTION_CREATE')")
    public ResponseEntity<?> create(CreateTransactionRequest createTransactionRequest) {
        try {
            return ResponseEntity.ok(transactionService.create(createTransactionRequest));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }
}
