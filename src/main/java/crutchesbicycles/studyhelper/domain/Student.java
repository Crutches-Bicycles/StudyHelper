package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;

/**
 * Сущность Student. \n
 * Состоит из полей:
 * @param idStudent
 * @param firstName -- Имя
 * @param secondName -- Фамилия
 * @param patronymic -- Отчество
 * @param group -- группа
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private long idStudent;

    @ManyToOne
    private Group group;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;
    private String patronymic;

    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Student() {
    }

    public Student(Group group, String firstName, String secondName, String patronymic) {
        this.group = group;
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
    }
}
