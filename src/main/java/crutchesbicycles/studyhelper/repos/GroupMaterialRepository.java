package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.GroupMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupMaterialRepository extends JpaRepository<GroupMaterial, Long> {
    List<GroupMaterial> findAllByGroupIdGroup(Long idGroup);
    Optional<GroupMaterial> findByGroupIdGroupAndIdMaterial(Long idGroup, Long idMaterial);
}
