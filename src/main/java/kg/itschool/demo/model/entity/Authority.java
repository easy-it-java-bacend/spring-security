package kg.itschool.demo.model.entity;

import javax.persistence.Entity;

public enum Authority {

    USER_READ,
    USER_CREATE,
    USER_DELETE,
    USER_UPDATE,

    ACCOUNT_READ,
    ACCOUNT_CREATE,
    ACCOUNT_DELETE,
    ACCOUNT_UPDATE,

    TRANSACTION_READ,
    TRANSACTION_CREATE,
    TRANSACTION_DELETE,

}
