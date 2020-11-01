package crutchesbicycles.studyhelper.security.jwt;

import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserDetailController extends UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findByEmail(s);
        optionalAccount.orElseThrow(

        );
        return null;
    }

    @Autowired
    public UserDetailController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
