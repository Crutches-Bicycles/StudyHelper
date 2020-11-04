package crutchesbicycles.studyhelper.security.jwt;


import com.sun.java.swing.action.ActionManager;
import crutchesbicycles.studyhelper.domain.Account;
import crutchesbicycles.studyhelper.domain.AccountType;
import crutchesbicycles.studyhelper.domain.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {


    public JwtUserFactory() {
    }

    public static JwtUser create(Account account){
        return new JwtUser(
                account.getIdAccount(),
                account.getEmail(),
                account.getPassword(),
                account.getRoles(),
                mapToGrantedAuthority(new ArrayList<>(account.getRoles() ))
        );
    }

    public static List<GrantedAuthority> mapToGrantedAuthority(List<Role> roles){
         return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
