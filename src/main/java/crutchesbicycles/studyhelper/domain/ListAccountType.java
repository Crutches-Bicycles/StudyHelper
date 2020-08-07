package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListAccountType {

    @Id
    @GeneratedValue
    private long idAccountType;
    private String description;

    public long getIdAccountType() {
        return idAccountType;
    }

    public void setIdAccountType(long idAccountType) {
        this.idAccountType = idAccountType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
