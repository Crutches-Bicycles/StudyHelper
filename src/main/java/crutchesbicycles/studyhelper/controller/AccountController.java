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


/**
 * Account controller -- контроллер для аккаунта \n
 * <b>Путь: /api/accounts/</b> \n
 * Если параметры не помечены как "(URL шаблон)", то это означет, что они типа form-data
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountsRepository accountRepository;
    private final StudentsRepository studentRepository;

    /**
     * Получить все аккаунты. Возвращает в формате JSON. \n
     * <b>Путь: /api/accounts</b> \n
     * Тип запроса: GET
     * @return json со списком аккаунтов
     */
    @GetMapping
    List<Accounts> getAccounts(){
        return accountRepository.findAll();
    }


    /**
     * Создает аккаунт в системе. \n
     * <b>Путь: /api/accounts</b> \n
     * Тип запроса: POST
     * @param email -- почта пользователя. Важно: email должен быть уникальным
     * @param password -- пароль пользователя. Должен передаваться уже ЗАШИФРОВАННЫЙ
     * @param accountType -- тип аккаунта. Администратор, например.
     * @return HTTP Status 201, если аккаунт удачно создан. Иначе выдает исключение AccountExistsException
     * @see AccountExistsException
     */
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

    /**
     * Получить аккаунт по id \n
     * <b>Путь: /api/accounts/{idAccount}</b> \n
     * Тип запроса: GET
     * @param idAccount (URL шаблон)
     * @return Json c данными аккаунта, также может выдавать исключение UserNotFoundException
     * @see UserNotFoundException
     */
    @GetMapping("{idAccount}")
    Accounts getAccountById(@PathVariable Long idAccount){
        Optional<Accounts> account = accountRepository.findByIdAccount(idAccount);
        account.orElseThrow(
                () -> new UserNotFoundException(idAccount.toString())
        );

        return account.get();
    }


    /**
     * Обновить аккаунт. \n
     * <b>Путь: /api/accounts/{idAccount}</b> \n
     * Тип запроса: PUT \n
     * @param idAccount (URL шаблон)
     * @param email -- почта
     * @param password -- пароль. Важно: должен быть зашифрован
     * @param accountType --  тип аккаунта
     * @param idStudent -- должен быть в любом случае, если не хотим добавлять, то просто оставляем поле со значением пустым
     * @return HTTP Status 200 в случае успешного обновления информации в аккаунте, также может выдавать исключение UserNotFoundException
     * @see UserNotFoundException
     */
    @PutMapping("{idAccount}")
    synchronized ResponseEntity<?> editAccount(@PathVariable Long idAccount, @RequestParam String email,
                                  @RequestParam String password, @RequestParam String accountType,
                                  @RequestParam Long idStudent){
        Optional<Accounts> account = accountRepository.findByIdAccount(idAccount);
        account.orElseThrow(
                ()-> new UserNotFoundException(idAccount.toString())
        );
        Optional<Students> optionalStudents = studentRepository.findByIdStudent(idStudent);
        Accounts tempAccount = account.get();
        optionalStudents.ifPresent(tempAccount::setStudent);
        if (!tempAccount.getEmail().equals(email)){
            tempAccount.setEmail(email);
        }

        if (!tempAccount.getPassword().equals(password)){
            tempAccount.setPassword(password);
        }

        if (!tempAccount.getAccountType().toString().equals(accountType)){
            tempAccount.setAccountType(ListAccountType.valueOf(accountType));
        }

        accountRepository.save(tempAccount);
        return new ResponseEntity<>("Information updated: " + idAccount, HttpStatus.OK);
    }

    /**
     * Удалить аккаунт. \n
     * <b>Путь: /api/accounts/{idAccount}</b> \n
     * Тип запроса: DELETE
     * @param idAccount (URL шаблон)
     * @return HTTP Status OK (200), если всё прошло успешно, также может выдавать исключение UserNotFoundException
     * @see UserNotFoundException
     */
    @DeleteMapping("{idAccount}")
    synchronized ResponseEntity<?> deleteAccount(@PathVariable Long idAccount){
        accountRepository.findByIdAccount(idAccount).orElseThrow(
                () -> new UserNotFoundException(idAccount.toString())
        );

        accountRepository.deleteById(idAccount);
        return new ResponseEntity<>("Account with Id '" + idAccount + "' deleted", HttpStatus.OK);
    }

    @Autowired
    public AccountController(AccountsRepository accountRepository, StudentsRepository studentRepository) {
        this.accountRepository = accountRepository;
        this.studentRepository = studentRepository;

    }


}
