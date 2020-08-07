package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class TeacherSubject {

    @Id
    @GeneratedValue
    private long idTeacherSubject;

    @OneToOne
    private Teachers teacher;

    @ManyToMany
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
