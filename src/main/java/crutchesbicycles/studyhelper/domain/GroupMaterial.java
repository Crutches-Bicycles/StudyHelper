package crutchesbicycles.studyhelper.domain;


import javax.persistence.*;
import java.util.List;

public class GroupMaterial {
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
}
