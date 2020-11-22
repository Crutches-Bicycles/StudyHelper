package crutchesbicycles.studyhelper.controller;


import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.domain.AccountType;
import crutchesbicycles.studyhelper.domain.Role;
import crutchesbicycles.studyhelper.domain.Student;
import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.UserNotFoundException;
import crutchesbicycles.studyhelper.repos.AccountRepository;
import crutchesbicycles.studyhelper.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Account controller -- контроллер для аккаунта \n
 * <b>Путь: /api/accounts/</b> \n
 * Если параметры не помечены как "(URL шаблон)", то это означет, что они типа form-data
 * <b>ПРОИСХОДИТ ТЕСТИРОВАНИЕ КЭШИРОВАНИЯ МОЖЕТ РАБОТАТЬ НЕ ОЧЕНЬ СТАБИЛЬНО</b>
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;

    /**
     * Получить все аккаунты. Возвращает в формате JSON. \n
     * <b>Путь: /api/accounts</b> \n
     * Тип запроса: GET
     * @return json со списком аккаунтов ({@link Account})
     */
    @GetMapping
    List<Account> getAccounts(){
        return accountRepository.findAll();
    }


    /**
     * <b>Не использовать вместо метода /register</b> \n
     * Создает аккаунт в системе. \n
     * <b>Путь: /api/accounts</b> \n
     *
     * @param email -- почта пользователя. Важно: email должен быть уникальным
     * @param password -- пароль пользователя. Должен передаваться уже ЗАШИФРОВАННЫЙ
     * @param roles -- тип аккаунта. Администратор, например.
     * @return HTTP Status 201, если аккаунт удачно создан. Иначе выдает исключение AccountExistsException
     * @see AccountExistsException
     * @see Account
     */
    // TODO: 02.11.2020 аккуратно с roles
    public ResponseEntity<?> createAccount(String email, String password,
                                                 List<Role> roles){
        if (accountRepository.findByEmail(email).isPresent()) {
            throw new AccountExistsException(email);
        }
        Account account = new Account(null, email, password, roles);
        accountRepository.save(account);
        return ResponseEntity.ok(account);
    }

    /**
     * Получить аккаунт по id \n
     * <b>Путь: /api/accounts/{idAccount}</b> \n
     * Тип запроса: GET
     * @param idAccount (URL шаблон)
     * @return Json c данными аккаунта ({@link Account}), также может выдавать исключение UserNotFoundException
     * @throws UserNotFoundException
     */
    @Cacheable(value = "accounts")
    @GetMapping("{idAccount}")
    public Account getAccountById(@PathVariable Long idAccount){
        Optional<Account> account = accountRepository.findByIdAccount(idAccount);
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
     * @param roles --  тип аккаунта
     * @param idStudent -- должен быть в любом случае, если не хотим добавлять, то просто оставляем поле со значением пустым
     * @return HTTP Status 200 с данными аккаунта ({@link Account}) в случае успешного обновления информации в аккаунте, также может выдавать исключение UserNotFoundException
     * @throws UserNotFoundException
     */
    @Cacheable(value = "accounts")
    @PutMapping("{idAccount}")
    public synchronized ResponseEntity<?> editAccount(@PathVariable Long idAccount, @RequestParam String email,
                                  @RequestParam String password, @RequestParam List<Role> roles,
                                  @RequestParam Long idStudent){
        Optional<Account> account = accountRepository.findByIdAccount(idAccount);
        account.orElseThrow(
                ()-> new UserNotFoundException(idAccount.toString())
        );
        Optional<Student> optionalStudents = studentRepository.findByIdStudent(idStudent);
        Account tempAccount = account.get();
        optionalStudents.ifPresent(tempAccount::setStudent);

        if (!tempAccount.getEmail().equals(email)){
            if (accountRepository.findByEmail(email).isPresent()){
                throw new AccountExistsException(email);
            }
            tempAccount.setEmail(email);
        }

        if (!tempAccount.getPassword().equals(password)){
            tempAccount.setPassword(password);
        }

        if (!tempAccount.getRoles().equals(roles)){
            tempAccount.setRoles(roles);
        }

        accountRepository.save(tempAccount);
        return ResponseEntity.ok(tempAccount);
    }

    /**
     * Удалить аккаунт. \n
     * <b>Путь: /api/accounts/{idAccount}</b> \n
     * Тип запроса: DELETE
     * @param idAccount (URL шаблон)
     * @return HTTP Status OK (200), если всё прошло успешно, также может выдавать исключение UserNotFoundException
     * @throws UserNotFoundException
     */
    @CacheEvict(value = "accounts")
    @DeleteMapping("{idAccount}")
    public synchronized ResponseEntity<?> deleteAccount(@PathVariable Long idAccount){
        accountRepository.findByIdAccount(idAccount).orElseThrow(
                () -> new UserNotFoundException(idAccount.toString())
        );

        accountRepository.deleteById(idAccount);
        return new ResponseEntity<>("Account with Id '" + idAccount + "' deleted", HttpStatus.OK);
    }

    @Autowired
    public AccountController(AccountRepository accountRepository, StudentRepository studentRepository) {
        this.accountRepository = accountRepository;
        this.studentRepository = studentRepository;

    }


}
