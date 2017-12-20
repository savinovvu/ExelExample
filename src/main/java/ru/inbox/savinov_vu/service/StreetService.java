package ru.inbox.savinov_vu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.encode.StreetEncoder;
import ru.inbox.savinov_vu.exel.StreetAndHomeExcelReader;
import ru.inbox.savinov_vu.model.Street;
import ru.inbox.savinov_vu.repository.StreetRepository;

import java.util.List;

@Service
public class StreetService {


    @Autowired
    private StreetRepository repository;


    public void add() {
        System.out.println();
        StreetAndHomeExcelReader streetAndHomeExcelReader = new StreetAndHomeExcelReader();
        Street street = streetAndHomeExcelReader.get().get(0);
        System.out.println("============================================================================");
        System.out.println();
        System.out.println("before added street: " + street);
        System.out.println();
        System.out.println("============================================================================");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        street = StreetEncoder.encode(street);

        System.out.println("============================================================================");
        System.out.println();
        System.out.println("after added street: " + street);
        System.out.println();
        System.out.println("============================================================================");
        repository.save(street);
    }

    public void get() {
        List<Street> streets = repository.findAll();
        System.out.println("****************************************************************************");
        for (Street street : streets) {
            System.out.println(street);
        }
        System.out.println("****************************************************************************");


    }

}
