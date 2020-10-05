package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Сущность Day. Список дней, с коротким названием. \n
 * Состоит из полей:
 * @param idDay
 * @param caption -- название дня (Понедельник и тд)
 * @param shortCaption -- короткое название (пн, вт и тд)
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */
@Entity
public class Day {
    @Id
    @GeneratedValue
    private long idDay;

    private String caption;
    private String shortCaption;

    public long getIdDay() {
        return idDay;
    }

    public void setIdDay(long idDay) {
        this.idDay = idDay;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getShortCaption() {
        return shortCaption;
    }

    public void setShortCaption(String shortCaption) {
        this.shortCaption = shortCaption;
    }

    public Day() {
    }

    public Day(String caption, String shortCaption) {
        this.caption = caption;
        this.shortCaption = shortCaption;
    }
}
