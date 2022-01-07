package kg.itschool.demo.controller;

import kg.itschool.demo.model.dto.AccountDto;
import kg.itschool.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @PreAuthorize("hasAuthority('ACCCOUNT_CREATE')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AccountDto accountDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(accountService.create(accountDto));
        } catch (RuntimeException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PreAuthorize("hasAuthority('ACCOUNT_UPDATE')")
    @PatchMapping("/update")
    public ResponseEntity<?> update(@RequestBody AccountDto accountDto) {
        return null;
    }
}
