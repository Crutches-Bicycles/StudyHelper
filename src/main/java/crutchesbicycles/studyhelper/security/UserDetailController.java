package crutchesbicycles.studyhelper.security;

import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.exception.AccountNotFoundException;
import crutchesbicycles.studyhelper.repos.AccountRepository;
import crutchesbicycles.studyhelper.security.jwt.JwtUser;
import crutchesbicycles.studyhelper.security.jwt.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
public class UserDetailController implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public JwtUser loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Account> optionalAccount = accountRepository.findByEmail(email);
        optionalAccount.orElseThrow(
                () -> new AccountNotFoundException(email)
        );
        JwtUser jwtUser = JwtUserFactory.create(optionalAccount.get());
        return jwtUser;
    }

    @Autowired
    public UserDetailController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}
