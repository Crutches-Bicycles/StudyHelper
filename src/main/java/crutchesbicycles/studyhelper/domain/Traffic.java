package crutchesbicycles.studyhelper.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Сущность Traffic. Посещение студентов.\n
 * Состоит из полей:
 * @param idStudent
 * @param student -- Студент
 * @param scheduleRecord -- Запись в расписании
 * @param date -- Дата пары
 * @param isAttend -- отметка посещения (true/false)
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Traffic {
    @Id
    @GeneratedValue
    private long idTraffic;

    @ManyToOne
    private Student student;

    @ManyToOne
    private ScheduleRecord scheduleRecord;

    @Temporal(TemporalType.DATE)
    private Date date;

    private boolean isAttend;

    public long getIdTraffic() {
        return idTraffic;
    }

    public void setIdTraffic(long idTraffic) {
        this.idTraffic = idTraffic;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ScheduleRecord getScheduleRecord() {
        return scheduleRecord;
    }

    public void setScheduleRecord(ScheduleRecord scheduleRecord) {
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

    public Traffic() {
    }

    public Traffic(Student student, ScheduleRecord scheduleRecord, Date date, boolean isAttend) {
        this.student = student;
        this.scheduleRecord = scheduleRecord;
        this.date = date;
        this.isAttend = isAttend;
    }
}
