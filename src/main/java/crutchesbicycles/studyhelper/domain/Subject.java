package crutchesbicycles.studyhelper.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Сущность Subject. Список предметов. \n
 * Состоит из полей:
 * @param idSubject
 * @param caption -- название предмета
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Subject implements Serializable {
    @Id
    @GeneratedValue
    private long idSubject;

    @Column(nullable = false, unique = true)
    private String caption;

    public long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(long idSubject) {
        this.idSubject = idSubject;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Subject() {
    }

    public Subject(String caption) {
        this.caption = caption;
    }
}
