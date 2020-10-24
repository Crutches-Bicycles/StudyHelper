package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Сущность ScheduleRecord. Записи в расписании. \n
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
public class ScheduleRecord implements Serializable {
    @Id
    @GeneratedValue
    private long idScheduleRecord;

    @ManyToOne
    private Schedule schedule;

    @ManyToOne
    private Day days;

    @ManyToOne
    private Pair pairs;

    @ManyToOne
    private Subject subjectEven;

    @ManyToOne
    private Subject subjectOdd;

    public long getIdScheduleRecord() {
        return idScheduleRecord;
    }

    public void setIdScheduleRecord(long idScheduleRecord) {
        this.idScheduleRecord = idScheduleRecord;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Day getDays() {
        return days;
    }

    public void setDays(Day days) {
        this.days = days;
    }

    public Pair getPairs() {
        return pairs;
    }

    public void setPairs(Pair pairs) {
        this.pairs = pairs;
    }

    public Subject getSubjectEven() {
        return subjectEven;
    }

    public void setSubjectEven(Subject subjectEven) {
        this.subjectEven = subjectEven;
    }

    public Subject getSubjectOdd() {
        return subjectOdd;
    }

    public void setSubjectOdd(Subject subjectOdd) {
        this.subjectOdd = subjectOdd;
    }

    public ScheduleRecord() {
    }

    public ScheduleRecord(Schedule schedule, Day days, Pair pairs, Subject subjectEven, Subject subjectOdd) {
        this.schedule = schedule;
        this.days = days;
        this.pairs = pairs;
        this.subjectEven = subjectEven;
        this.subjectOdd = subjectOdd;
    }
}
