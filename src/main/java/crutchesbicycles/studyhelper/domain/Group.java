package crutchesbicycles.studyhelper.domain;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Сущность Group. Описывает группу. \n
 * Состоит из полей:
 * @param idGroup
 * @param caption (nullable = false) -- название группы
 * @param email  (nullable = false, unique = true) -- почта группы
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity(name = "group_")
public class Group implements Serializable {
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

    public Group() {
    }

    public Group(String caption, String email) {
        this.caption = caption;
        this.email = email;
    }
}
