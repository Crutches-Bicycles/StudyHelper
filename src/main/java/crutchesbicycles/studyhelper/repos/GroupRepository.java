package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findAll();
    Optional<Group> findByIdGroup(Long idGroup);
    List<Group> findByEmailOrCaption(String email, String caption);
}
