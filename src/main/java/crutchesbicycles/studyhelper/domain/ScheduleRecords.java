package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ScheduleRecords {
    @Id
    private long idScheduleRecord;

    @ManyToOne
    private Schedules schedule;

    private long idDay;
    private long idPair;
    private long idSubjectEven;
    private long idSubjectOdd;

    public long getIdScheduleRecord() {
        return idScheduleRecord;
    }

    public void setIdScheduleRecord(long idScheduleRecord) {
        this.idScheduleRecord = idScheduleRecord;
    }

    public Schedules getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedules schedule) {
        this.schedule = schedule;
    }

    public long getIdDay() {
        return idDay;
    }

    public void setIdDay(long idDay) {
        this.idDay = idDay;
    }

    public long getIdPair() {
        return idPair;
    }

    public void setIdPair(long idPair) {
        this.idPair = idPair;
    }

    public long getIdSubjectEven() {
        return idSubjectEven;
    }

    public void setIdSubjectEven(long idSubjectEven) {
        this.idSubjectEven = idSubjectEven;
    }

    public long getIdSubjectOdd() {
        return idSubjectOdd;
    }

    public void setIdSubjectOdd(long idSubjectOdd) {
        this.idSubjectOdd = idSubjectOdd;
    }
}
