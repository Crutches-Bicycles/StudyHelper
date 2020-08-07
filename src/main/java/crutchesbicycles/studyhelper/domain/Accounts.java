package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.io.Serializable;

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
