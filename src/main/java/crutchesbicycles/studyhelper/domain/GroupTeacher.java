package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class GroupTeacher {
    @Id
    private long idGroupTeacher;

    @ManyToMany
    private List<Groups> groups;
}
