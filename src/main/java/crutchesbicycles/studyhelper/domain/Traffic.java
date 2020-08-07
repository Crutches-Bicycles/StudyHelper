package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Traffic {
    @Id
    private long idTraffic;

    @ManyToOne
    private Students student;

    @ManyToOne
    private ScheduleRecords scheduleRecord;

    @Temporal(TemporalType.DATE)
    private Date date;

    private boolean isAttend;

    public long getIdTraffic() {
        return idTraffic;
    }

    public void setIdTraffic(long idTraffic) {
        this.idTraffic = idTraffic;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    public ScheduleRecords getScheduleRecord() {
        return scheduleRecord;
    }

    public void setScheduleRecord(ScheduleRecords scheduleRecord) {
        this.scheduleRecord = scheduleRecord;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isAttend() {
        return isAttend;
    }

    public void setAttend(boolean attend) {
        isAttend = attend;
    }
}
