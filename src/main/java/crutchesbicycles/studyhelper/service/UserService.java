package crutchesbicycles.studyhelper.service;

import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.domain.Role;
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


    public Account register(Account account){
        Role role = roleRepository.findByName("ROLE_USER");
        List<Role> roleList = new ArrayList<>();
        roleList.add(role);
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
