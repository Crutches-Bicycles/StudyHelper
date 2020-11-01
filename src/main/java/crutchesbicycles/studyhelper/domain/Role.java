package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }

    private String name; 
}
