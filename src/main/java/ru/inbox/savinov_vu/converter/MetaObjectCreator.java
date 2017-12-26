package ru.inbox.savinov_vu.converter;

import ru.inbox.savinov_vu.commonInterfaces.Identify;
import ru.inbox.savinov_vu.model.MetaObject;

import java.util.ArrayList;
import java.util.List;

public class MetaObjectCreator {
    private MetaObjectCreator() {
    }

    public static List<MetaObject> convert(List<Identify> identifies) {
        List<MetaObject> metaObjects = new ArrayList<>();
        for (Identify identify : identifies) {
            String metaClassName = getMetaClassName(identify);
            MetaObject metaObject = new MetaObject(identify.getId(), "1", metaClassName);
            metaObjects.add(metaObject);
        }
        return metaObjects;
    }

    private static String getMetaClassName(Identify identify) {
        switch (identify.getClass().getSimpleName()) {
            case "Apartment":
                return "apartment";
            case "Home":
                return "home";
            case "Street":
                return "street";
            case "Contragent":
                return "contragent";
        }
        throw new IllegalArgumentException(identify.getClass().getSimpleName());
    }

}
