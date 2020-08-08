package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Сущность ScheduleRecords. Записи в расписании. \n
 * Состоит из полей:
 * @param idScheduleRecord
 * @param schedule -- полное расписание
 * @param days -- день пары
 * @param pairs -- номер пары
 * @param subjectEven -- пара на четной неделе
 * @param subjectOdd -- пара на нечетной неделе
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
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
    private ListSubjects subjectEven;

    @ManyToOne
    private ListSubjects subjectOdd;

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

    public ListSubjects getSubjectEven() {
        return subjectEven;
    }

    public void setSubjectEven(ListSubjects subjectEven) {
        this.subjectEven = subjectEven;
    }

    public ListSubjects getSubjectOdd() {
        return subjectOdd;
    }

    public void setSubjectOdd(ListSubjects subjectOdd) {
        this.subjectOdd = subjectOdd;
    }
}
