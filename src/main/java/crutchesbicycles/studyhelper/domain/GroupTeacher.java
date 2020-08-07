package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupTeacher {
    @Id
    @GeneratedValue
    private long idGroupTeacher;

    @OneToOne
    private Groups group;

    @ManyToMany
    private List<Teachers> teachers;

    public long getIdGroupTeacher() {
        return idGroupTeacher;
    }

    public void setIdGroupTeacher(long idGroupTeacher) {
        this.idGroupTeacher = idGroupTeacher;
    }

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public List<Teachers> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teachers> teachers) {
        this.teachers = teachers;
    }
}
