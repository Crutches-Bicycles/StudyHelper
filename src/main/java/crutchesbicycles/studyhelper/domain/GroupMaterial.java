package crutchesbicycles.studyhelper.domain;


import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

public class GroupMaterial {
    @Id
    private long idMaterial;

    @OneToMany
    private List<ListSubjects> subject;

    private String linkTo;
    private String file;
    private String caption;
    private String description;
    private String labelSubject;

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

    public String getLabelSubject() {
        return labelSubject;
    }

    public void setLabelSubject(String labelSubject) {
        this.labelSubject = labelSubject;
    }
}
