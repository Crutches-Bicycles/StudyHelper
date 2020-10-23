package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.StudentMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentMaterialRepository extends JpaRepository<StudentMaterial, Long> {
    List<StudentMaterial> findByStudentIdStudent(Long idStudent);
    Optional<StudentMaterial> findByStudentIdStudentAndIdMaterial(Long idStudent, Long idMaterial);
}
