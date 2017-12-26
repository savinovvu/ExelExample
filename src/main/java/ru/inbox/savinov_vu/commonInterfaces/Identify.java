package ru.inbox.savinov_vu.commonInterfaces;

import org.springframework.data.domain.Persistable;

public interface Identify extends Persistable {
    @Override
    String getId();

    @Override
    default  boolean isNew() {
        return (getId() == null);
    }


}
