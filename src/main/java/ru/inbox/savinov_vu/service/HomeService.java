package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.commonInterfaces.CRUD;
import ru.inbox.savinov_vu.model.Home;
import ru.inbox.savinov_vu.repository.HomeRepository;

import java.util.List;

@Service
public class HomeService implements CRUD<Home> {

    @Autowired
    private HomeRepository repository;

    @Override
    public List<Home> getAll() {
        return repository.findAll();
    }
}
