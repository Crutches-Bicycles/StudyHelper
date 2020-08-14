package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.List;


/**
 * Сущность GroupTeacher. Привязка преподавателей к группе. \n
 * Состоит из полей:
 * @param idGroupTeacher
 * @param group -- группа
 * @param teachers -- список преподавателей группы
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
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

    public GroupTeacher() {
    }

    public GroupTeacher(Groups group, List<Teachers> teachers) {
        this.group = group;
        this.teachers = teachers;
    }
}
