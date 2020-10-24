package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.io.Serializable;
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
public class GroupTeacher implements Serializable {
    @Id
    @GeneratedValue
    private long idGroupTeacher;

    @OneToOne
    private Group group;

    @ManyToMany
    private List<Teacher> teachers;

    public long getIdGroupTeacher() {
        return idGroupTeacher;
    }

    public void setIdGroupTeacher(long idGroupTeacher) {
        this.idGroupTeacher = idGroupTeacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public GroupTeacher() {
    }

    public GroupTeacher(Group group, List<Teacher> teachers) {
        this.group = group;
        this.teachers = teachers;
    }
}
