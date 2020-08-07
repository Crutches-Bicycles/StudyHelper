package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;

@Entity
public class Students {
    @Id
    @GeneratedValue
    private long idStudent;

    @ManyToOne
    private Groups group;

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

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
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
}
