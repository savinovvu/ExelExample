package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.commonInterfaces.CRUD;
import ru.inbox.savinov_vu.model.MetaObject;
import ru.inbox.savinov_vu.repository.MetaObjectRepository;

import java.util.List;

@Service
public class MetaObjectService implements CRUD<MetaObject> {

    @Autowired
    private MetaObjectRepository repository;

    @Override
    public void add(List<MetaObject> list) {
        repository.save(list);
    }
}
