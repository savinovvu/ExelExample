package ru.inbox.savinov_vu.encode;

import ru.inbox.savinov_vu.model.Street;

public class StreetEncoder {

    private StreetEncoder() {
    }

    public static Street encode(Street street) {
        street.setId(Encoder.encode(street.getId()));
        street.setName(Encoder.encode(street.getName()));
        return street;
    }

}
