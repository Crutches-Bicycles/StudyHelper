package crutchesbicycles.studyhelper.service;

import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.domain.Role;
import crutchesbicycles.studyhelper.exception.AccountExistsException;
import crutchesbicycles.studyhelper.exception.AccountNotFoundException;
import crutchesbicycles.studyhelper.repos.AccountRepository;
import crutchesbicycles.studyhelper.repos.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    /**
     *
     * @param account
     * @param i - если занчение 0, то автоматически пользователю назначается роль пользователя
     *          если значение 1, то староста+пользователь
     *          если 2, то админ+староста+пользователь
     * @return Account
     */
    public Account register(Account account, int i){

        if (accountRepository.findByEmail(account.getEmail()).isPresent()){
            throw new AccountExistsException(account.getEmail());
        }

        Role userRole = roleRepository.findByName("ROLE_USER");
        Role adminRole;
        Role headmanRole;

        List<Role> roleList = new ArrayList<>();
        roleList.add(userRole);

        if (i == 1){
            headmanRole =roleRepository.findByName("ROLE_HEADMAN");
            roleList.add(headmanRole);
        }
        if (i == 2){
            headmanRole = roleRepository.findByName("ROLE_HEADMAN");
            adminRole = roleRepository.findByName("ROLE_ADMIN");
            roleList.add(headmanRole);
            roleList.add(adminRole);
        }

        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        account.setRoles(roleList);
        return accountRepository.save(account);
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account findByEmail(String email){
        Optional<Account> accountOptional = accountRepository.findByEmail(email);
        accountOptional.orElseThrow(
                () -> new AccountNotFoundException(email)
        );

        return accountOptional.get();
    }

    @Autowired
    public UserService(AccountRepository accountRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
}
