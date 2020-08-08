package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность StudentMaterial. Материалы студента. \n
 * Состоит из полей:
 * @param idMaterial
 * @param student -- студенты
 * @param linkTo -- местоположение файла (ссылка)
 * @param file -- навзание файла
 * @param caption -- публичное название файла
 * @param description -- описание файла
 * @param subject -- метки предметов
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class StudentMaterial {
    @Id
    @GeneratedValue
    private long idMaterial;

    @ManyToOne
    private Students student;

    @Column(nullable = false)
    private String linkTo;

    @Column(nullable = false)
    private String file;

    @Column(nullable = false)
    private String caption;

    private String description;

    @ManyToMany
    private List<ListSubjects> subject;

    public long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
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

    public List<ListSubjects> getSubject() {
        return subject;
    }

    public void setSubject(List<ListSubjects> subject) {
        this.subject = subject;
    }
}
