package crutchesbicycles.studyhelper.domain;

/**
 * Сущность AccountType. Список типов аккаунтов.\n
 * Состоит из полей:
 * @param idAccountType
 * @param description
 * @author vgtstptlk / Magerram Zeynalov
 * @version 1.0.0
 */

public enum AccountType {
    ADMIN,
    HEADMAN,
    USER;

    AccountType() {
    }
}
