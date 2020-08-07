package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
public class TeacherSubject {

    @Id
    private long idTeacherSubject;

    // DON'T SURE
    @OneToOne
    private Teachers teacher;

    @OneToMany
    private List<ListSubjects> subjects;

    public long getIdTeacherSubject() {
        return idTeacherSubject;
    }

    public void setIdTeacherSubject(long idTeacherSubject) {
        this.idTeacherSubject = idTeacherSubject;
    }

    public Teachers getTeacher() {
        return teacher;
    }

    public void setTeacher(Teachers teacher) {
        this.teacher = teacher;
    }

    public List<ListSubjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<ListSubjects> subjects) {
        this.subjects = subjects;
    }
}
