package crutchesbicycles.studyhelper.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Сущность GroupMaterial. Содержит материалы группы.
 * @param idMaterial
 * @param subject -- Предмет
 * @param linkTo -- Ссылка на файл
 * @param file -- Название файла
 * @param caption -- Публичное название файла
 * @param description -- Описание файла
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class GroupMaterial implements Serializable {

    /** Уникальный id */
    @Id
    @GeneratedValue
    private long idMaterial;


    @OneToMany
    private List<Subject> subject;

    @Column(nullable = false)
    private String linkTo;

    @Column(nullable = false)
    private String file;

    @Column(nullable = false)
    private String caption;

    private String description;

    @ManyToMany
    private List<Subject> labelSubject;

    @ManyToOne
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    public String getLinkTo() {
        return linkTo;
    }

    public void setLinkTo(String linkTo) {
        this.linkTo = linkTo;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Subject> getLabelSubject() {
        return labelSubject;
    }

    public void setLabelSubject(List<Subject> labelSubject) {
        this.labelSubject = labelSubject;
    }

    public GroupMaterial(List<Subject> subject, String linkTo, String file, String caption, String description,
                         List<Subject> labelSubject, Group group) {
        this.subject = subject;
        this.linkTo = linkTo;
        this.file = file;
        this.caption = caption;
        this.description = description;
        this.labelSubject = labelSubject;
        this.group = group;
    }
}
