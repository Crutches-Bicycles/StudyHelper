package crutchesbicycles.studyhelper.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Сущность ListAccountType. Список типов аккаунтов.\n
 * Состоит из полей:
 * @param idAccountType
 * @param description
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */

public enum ListAccountType {
    ADMIN,
    USER;

    ListAccountType() {
    }
}
