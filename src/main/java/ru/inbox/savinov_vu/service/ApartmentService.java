package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.commonInterfaces.CRUD;
import ru.inbox.savinov_vu.model.Apartment;
import ru.inbox.savinov_vu.repository.ApartmentRepository;

import java.util.List;

@Service
public class ApartmentService implements CRUD<Apartment> {

    @Autowired
    ApartmentRepository repository;

    @Override
    public List<Apartment> getAll() {
        return repository.findAll();
    }
}
