package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.Home;
import ru.inbox.savinov_vu.repository.HomeRepository;

import java.util.Collection;
import java.util.Map;

@Service
public class HomeService {

    @Autowired
    private HomeRepository repository;

    public void add(Map<String, Home> homeMap) {
        Collection<Home> values = homeMap.values();
        repository.save(values);
    }
}
