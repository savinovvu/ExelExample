package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.commonInterfaces.CRUD;
import ru.inbox.savinov_vu.model.Street;
import ru.inbox.savinov_vu.repository.StreetRepository;

import java.util.List;

@Service
public class StreetService implements CRUD<Street>{


    @Autowired
    private StreetRepository repository;


    @Override
    public List<Street> getAll() {
        return repository.findAll();
    }

}
