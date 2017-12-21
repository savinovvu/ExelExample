package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.Apartment;
import ru.inbox.savinov_vu.repository.ApartmentRepository;

import java.util.Collection;
import java.util.Map;

@Service
public class ApartmentService {

    @Autowired
    ApartmentRepository repository;

    public void add(Map<String,Apartment> apartmentMap) {
        Collection<Apartment> apartments = apartmentMap.values();
        repository.save(apartments);
    }

}
