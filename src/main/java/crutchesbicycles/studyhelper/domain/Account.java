package crutchesbicycles.studyhelper.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Сущность Account. Предоставляет основные поля для аккаунта, внезависимости от типа аккаунта.\n
 * Расширяет сущность Student.\n
 * Состоит из полей:\n
 * @param idAccount -- уникальный id\n
 * @param student -- Student
 * @param email -- почта пользователя
 * @param password -- пароль
 * @param accountType -- тип аккаунта, может быть как староста, зам старосты и просто студент
 * @see Student
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private long idAccount;

    @OneToOne
    private Student student;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToMany
    private List<Role> roles;


    public Account() {
    }

    public Account(Student student, String email, String password, List<Role> roles) {
        this.student = student;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
