package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.Street;
import ru.inbox.savinov_vu.repository.StreetRepository;

import java.util.Collection;
import java.util.Map;

@Service
public class StreetService {


    @Autowired
    private StreetRepository repository;



    public void add(Map<String, Street> streetMap) {
        Collection<Street> values = streetMap.values();
        repository.save(values);
    }
}
