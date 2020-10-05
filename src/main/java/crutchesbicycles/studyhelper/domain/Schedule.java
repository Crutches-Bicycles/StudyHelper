package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Сущность Schedule. Полное расписание. \n
 * Состоит из полей:
 * @param idSchedule
 * @param group -- группа
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private long idSchedule;

    @ManyToOne
    private Group group;

    public long getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(long idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Schedule() {
    }

    public Schedule(Group group) {
        this.group = group;
    }
}
