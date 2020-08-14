package crutchesbicycles.studyhelper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Сущность Teachers. \n
 * Состоит из полей:
 * @param idTeacher
 * @param firstName -- Имя
 * @param secondName -- Фамилия
 * @param patronymic -- Отчество
 * @param email -- почта
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Teachers {
    @Id
    @GeneratedValue
    private long idTeacher;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String secondName;

    private String patronymic;

    @Column(nullable = false, unique = true)
    private String email;

    public long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(long idTeacher) {
        this.idTeacher = idTeacher;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Teachers() {
    }

    public Teachers(String firstName, String secondName, String patronymic, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.email = email;
    }
}
