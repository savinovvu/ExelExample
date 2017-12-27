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
                return "dict_apartment";
            case "Home":
                return "dict_building";
            case "Street":
                return "dict_street";
            case "Contragent":
                return "dict_contractor";
        }
        throw new IllegalArgumentException(identify.getClass().getSimpleName());
    }

}
