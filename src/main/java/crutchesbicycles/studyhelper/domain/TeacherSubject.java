package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность TeacherSubject. Предметы, которые ведет преподаватель.\n
 * Состоит из полей:
 * @param idStudent
 * @param teacher -- Преподаватель
 * @param subjects -- Предметы
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
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

    public TeacherSubject() {
    }

    public TeacherSubject(Teachers teacher, List<ListSubjects> subjects) {
        this.teacher = teacher;
        this.subjects = subjects;
    }
}
