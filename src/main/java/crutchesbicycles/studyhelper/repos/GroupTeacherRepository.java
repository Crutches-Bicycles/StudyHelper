package crutchesbicycles.studyhelper.repos;

import crutchesbicycles.studyhelper.domain.GroupTeacher;
import crutchesbicycles.studyhelper.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupTeacherRepository extends JpaRepository<GroupTeacher, Long> {
    List<GroupTeacher> findAll();
    Optional<GroupTeacher> findByGroupIdGroup(Long idGroup);
    List<GroupTeacher> findAllByTeachersContaining(Teacher teacher);


}
