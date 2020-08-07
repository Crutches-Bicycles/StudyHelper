package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ListPairs {
    @Id
    @GeneratedValue
    private long idPair;

    private long number;

    @Temporal(TemporalType.TIME)
    private Date startTime;

    @Temporal(TemporalType.TIME)
    private Date endTime;

    public long getIdPair() {
        return idPair;
    }

    public void setIdPair(long idPair) {
        this.idPair = idPair;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
