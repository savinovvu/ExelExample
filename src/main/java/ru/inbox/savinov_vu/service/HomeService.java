package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.repository.HomeRepository;

@Service
public class HomeService {

    @Autowired
    private HomeRepository repository;

}
