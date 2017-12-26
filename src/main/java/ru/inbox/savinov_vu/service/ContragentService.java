package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.commonInterfaces.CRUD;
import ru.inbox.savinov_vu.model.Contragent;
import ru.inbox.savinov_vu.repository.ContragentRepository;

import java.util.List;

@Service
public class ContragentService implements CRUD<Contragent> {
    @Autowired
    private ContragentRepository repository;

    @Override
    public List<Contragent> getAll() {
        return repository.findAll();
    }
}
