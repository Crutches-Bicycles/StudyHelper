package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Сущность Accounts. Предоставляет основные поля для аккаунта, внезависимости от типа аккаунта.\n
 * Расширяет сущность Students.\n
 * Состоит из полей:\n
 * @param idAccount -- уникальный id\n
 * @param student -- Students
 * @param email -- почта пользователя
 * @param password -- пароль
 * @param accountType -- тип аккаунта, может быть как староста, зам старосты и просто студент
 * @see Students
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Accounts implements Serializable {
    @Id
    @GeneratedValue
    private long idAccount;

    @OneToOne
    private Students student;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne
    private ListAccountType accountType;

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
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

    public ListAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(ListAccountType accountType) {
        this.accountType = accountType;
    }
}
