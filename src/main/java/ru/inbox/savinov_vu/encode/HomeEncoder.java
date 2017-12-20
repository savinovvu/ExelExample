package ru.inbox.savinov_vu.encode;

import ru.inbox.savinov_vu.model.Home;

public class HomeEncoder {

    private HomeEncoder() {
    }

    public static Home encode(Home home) {
         home.setId(Encoder.encode(home.getId()));
         home.setName(Encoder.encode(home.getName()));
         home.setFull_name(Encoder.encode(home.getFull_name()));
        return home;
    }
}
