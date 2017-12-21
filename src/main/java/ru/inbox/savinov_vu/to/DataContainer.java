package ru.inbox.savinov_vu.to;

import ru.inbox.savinov_vu.model.Apartment;
import ru.inbox.savinov_vu.model.Home;
import ru.inbox.savinov_vu.model.Street;

import java.util.HashMap;
import java.util.Map;

public class DataContainer {
    public Map<String, Street> streetMap = new HashMap<>();
    public Map<String, Home> homeMap = new HashMap<>();
    public Map<String, Apartment> apartmentMap = new HashMap<>();
}
