package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.model.Street;
import ru.inbox.savinov_vu.repository.StreetRepository;

@Service
public class StreetService {


    @Autowired
    private StreetRepository repository;


    public void add() {
        System.out.println();
        Street street = new Street("МоковаяУлица");
        System.out.println("============================================================================");
        System.out.println();
        System.out.println("before added street: " + street);
        System.out.println();
        System.out.println("============================================================================");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        street.setName(street.getName());
        System.out.println("============================================================================");
        System.out.println();
        System.out.println("after added street: " + street);
        System.out.println();
        System.out.println("============================================================================");
        repository.save(street);

    }
}
