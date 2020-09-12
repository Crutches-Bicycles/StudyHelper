package crutchesbicycles.studyhelper.domain;


import javax.persistence.*;
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
public class GroupMaterial {

    /** Уникальный id */
    @Id
    @GeneratedValue
    private long idMaterial;


    @OneToMany
    private List<ListSubjects> subject;

    @Column(nullable = false)
    private String linkTo;

    @Column(nullable = false)
    private String file;

    @Column(nullable = false)
    private String caption;

    private String description;

    @ManyToMany
    private List<ListSubjects> labelSubject;

    @ManyToOne
    private Groups group;

    public Groups getGroup() {
        return group;
    }

    public void setGroup(Groups group) {
        this.group = group;
    }

    public long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public List<ListSubjects> getSubject() {
        return subject;
    }

    public void setSubject(List<ListSubjects> subject) {
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

    public List<ListSubjects> getLabelSubject() {
        return labelSubject;
    }

    public void setLabelSubject(List<ListSubjects> labelSubject) {
        this.labelSubject = labelSubject;
    }

    public GroupMaterial(List<ListSubjects> subject, String linkTo, String file, String caption, String description,
                         List<ListSubjects> labelSubject, Groups group) {
        this.subject = subject;
        this.linkTo = linkTo;
        this.file = file;
        this.caption = caption;
        this.description = description;
        this.labelSubject = labelSubject;
        this.group = group;
    }
}
