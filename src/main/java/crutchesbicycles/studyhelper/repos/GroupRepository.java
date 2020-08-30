package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Groups, Long> {
    List<Groups> findAll();
    Optional<Groups> findByIdGroup(Long idGroup);
    Optional<Groups> findByEmailOrCaption(String email, String caption);
}
