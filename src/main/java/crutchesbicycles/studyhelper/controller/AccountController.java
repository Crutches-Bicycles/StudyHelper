package crutchesbicycles.studyhelper.controller;


import crutchesbicycles.studyhelper.domain.Accounts;
import crutchesbicycles.studyhelper.domain.ListAccountType;
import crutchesbicycles.studyhelper.domain.Students;
import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
import crutchesbicycles.studyhelper.repos.AccountsRepository;
import crutchesbicycles.studyhelper.repos.StudentsRepository;
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
    private final StudentsRepository studentRepository;

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
    synchronized ResponseEntity<?> editAccount(@PathVariable Long idAccount, @RequestParam String email,
                                  @RequestParam String password, @RequestParam String accountType,
                                  @RequestParam Long idStudent){
        Optional<Accounts> account = accountRepository.findByIdAccount(idAccount);
        account.orElseThrow(
                ()-> new UserNotFoundException(idAccount.toString())
        );
        Students tempStudent = null;
        Optional<Students> optionalStudents = studentRepository.findByIdStudent(idStudent);
        Accounts tempAccount = account.get();
        optionalStudents.ifPresent(tempAccount::setStudent);
        if (!email.isEmpty()){
            tempAccount.setEmail(email);
        }

        if (!password.isEmpty()){
            tempAccount.setPassword(password);
        }

        if (!accountType.isEmpty()){
            tempAccount.setAccountType(ListAccountType.valueOf(accountType));
        }

        accountRepository.save(tempAccount);
        return new ResponseEntity<>("Information updated: " + idAccount, HttpStatus.OK);
    }

    @DeleteMapping("{idAccount}")
    synchronized ResponseEntity<?> deleteAccount(@PathVariable Long idAccount){
        accountRepository.findByIdAccount(idAccount).orElseThrow(
                () -> new UserNotFoundException(idAccount.toString())
        );

        accountRepository.deleteByIdAccount(idAccount);
        return new ResponseEntity<>("Account with Id '" + idAccount + "' deleted", HttpStatus.OK);
    }

    @Autowired
    public AccountController(AccountsRepository accountRepository, StudentsRepository studentRepository) {
        this.accountRepository = accountRepository;
        this.studentRepository = studentRepository;

    }


}
