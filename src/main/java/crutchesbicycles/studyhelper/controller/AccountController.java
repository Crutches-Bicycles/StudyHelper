package crutchesbicycles.studyhelper.controller;


import crutchesbicycles.studyhelper.domain.Accounts;
import crutchesbicycles.studyhelper.domain.ListAccountType;
import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.repos.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountsRepository accountRepository;

    @GetMapping
    List<Accounts> getAccounts(){
        return accountRepository.findAll();
    }

    @PostMapping
    synchronized ResponseEntity<?> createAccount(@RequestParam String email, @RequestParam String password,
                                                 @RequestParam String accountType){
        if (accountRepository.findByEmail(email).isPresent()) {
            throw new AccountExistsException(email);
        }
        Accounts account = new Accounts(null, email, password, ListAccountType.valueOf(accountType));
        accountRepository.save(account);
        return new ResponseEntity<>("Account with email " + email + " Created", HttpStatus.CREATED);
    }

    @Autowired
    public AccountController(AccountsRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


}
