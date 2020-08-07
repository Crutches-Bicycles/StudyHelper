package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ScheduleRecords {
    @Id
    @GeneratedValue
    private long idScheduleRecord;

    @ManyToOne
    private Schedules schedule;

    @ManyToOne
    private ListDays days;

    @ManyToOne
    private ListPairs pairs;

    @ManyToOne
    private ListSubjects idSubjectEven;

    @ManyToOne
    private ListSubjects idSubjectOdd;

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

    public ListDays getDays() {
        return days;
    }

    public void setDays(ListDays days) {
        this.days = days;
    }

    public ListPairs getPairs() {
        return pairs;
    }

    public void setPairs(ListPairs pairs) {
        this.pairs = pairs;
    }

    public ListSubjects getIdSubjectEven() {
        return idSubjectEven;
    }

    public void setIdSubjectEven(ListSubjects idSubjectEven) {
        this.idSubjectEven = idSubjectEven;
    }

    public ListSubjects getIdSubjectOdd() {
        return idSubjectOdd;
    }

    public void setIdSubjectOdd(ListSubjects idSubjectOdd) {
        this.idSubjectOdd = idSubjectOdd;
    }
}
