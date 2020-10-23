package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAll();
    Optional<Account> findByEmail(String email);
    Optional<Account> findByIdAccount(Long idAccount);
}
