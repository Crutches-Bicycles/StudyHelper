package crutchesbicycles.studyhelper.security.jwt;

import crutchesbicycles.studyhelper.domain.AccountType;
import crutchesbicycles.studyhelper.domain.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Collection;

public class JwtUser implements UserDetails {


    private final Long  idAccount;
    private final String email;
    private final String password;
    @Enumerated(EnumType.STRING)
    private final AccountType accountType;


    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(Long idAccount,
                   String email,
                   String password,
                   AccountType accountType,
                   Collection<? extends GrantedAuthority> authorities) {
        this.idAccount = idAccount;
        this.email = email;
        this.password = password;
        this.accountType = accountType;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }


    public Long getIdAccount() {
        return idAccount;
    }

    public String getEmail() {
        return email;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
