package crutchesbicycles.studyhelper.security.jwt;


import com.sun.java.swing.action.ActionManager;
import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.domain.AccountType;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public final class JwtUserFactory {


    public JwtUserFactory() {
    }

    public static JwtUser create(Account account){
        return new JwtUser(
                account.getIdAccount(),
                account.getEmail(),
                account.getPassword(),
                account.getAccountType(),
                null
        );
    }

    public static List<GrantedAuthority> mapToGrantedAuthority(AccountType accountType){
        return AccountType.stream
    }
}
