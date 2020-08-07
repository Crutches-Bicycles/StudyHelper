package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListDays {
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
}
