package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    List<Accounts> findAll();
    Optional<Accounts> findByEmail(String email);
    Optional<Accounts> findByIdAccount(Long idAccount);
}
