package crutchesbicycles.studyhelper.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Сущность Groups. Описывает группу. \n
 * Состоит из полей:
 * @param idGroup
 * @param caption (nullable = false) -- название группы
 * @param email  (nullable = false, unique = true) -- почта группы
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Groups {
    @Id
    @GeneratedValue
    private long idGroup;

    @Column(nullable = false)
    private String caption;

    @Column(nullable = false, unique = true)
    private String email;

    public long getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Groups() {
    }

    public Groups(String caption, String email) {
        this.caption = caption;
        this.email = email;
    }
}
