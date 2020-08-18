package crutchesbicycles.studyhelper.controller;


import crutchesbicycles.studyhelper.domain.Accounts;
import crutchesbicycles.studyhelper.domain.ListAccountType;
import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
import crutchesbicycles.studyhelper.repos.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{idAccount}")
    Accounts getAccountById(@PathVariable Long idAccount){
        Optional<Accounts> account = accountRepository.findByIdAccount(idAccount);
        account.orElseThrow(
                () -> new UserNotFoundException(idAccount.toString())
        );

        return account.get();
    }


    // todo: Do not forget to finish writing
    @PutMapping("{idAccount}")
    ResponseEntity<?> editAccount(@PathVariable Long idAccount, @RequestParam String email,
                                  @RequestParam String password, @RequestParam String accountType,
                                  @RequestParam Long idStudent){
        Optional<Accounts> account = accountRepository.findByIdAccount(idAccount);
        account.orElseThrow(
                ()-> new UserNotFoundException(idAccount.toString())
        );

        // todo: Search from id student and connect to account
    }

    @Autowired
    public AccountController(AccountsRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


}
