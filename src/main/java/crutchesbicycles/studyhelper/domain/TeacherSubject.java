package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.io.Serializable;
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
public class TeacherSubject implements Serializable {

    @Id
    @GeneratedValue
    private long idTeacherSubject;

    @OneToOne
    private Teacher teacher;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.ALL})
    private List<Subject> subjects;

    public long getIdTeacherSubject() {
        return idTeacherSubject;
    }

    public void setIdTeacherSubject(long idTeacherSubject) {
        this.idTeacherSubject = idTeacherSubject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public TeacherSubject() {
    }

    public TeacherSubject(Teacher teacher, List<Subject> subjects) {
        this.teacher = teacher;
        this.subjects = subjects;
    }
}
