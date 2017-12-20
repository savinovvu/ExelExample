package ru.inbox.savinov_vu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorService {

    @Autowired
    private ContractorRepository repository;

    private void save(List<Contractor> contractors) {
        System.out.println("==============================================================================");
        System.out.println();
        System.out.println("added Line from Exel: " + contractors.size());
        System.out.println();
        System.out.println("==============================================================================");
        repository.save(contractors);
    }

    private void getToConsoleFromBD() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        List<Contractor> contractors = repository.findAll();
        System.out.println();
        System.out.println("Count line in BD: " + contractors.size());
        System.out.println();
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        for (Contractor contractor :contractors) {
            System.out.println(contractor);
            System.out.println("");
        }
        System.out.println("_______________________________________________________________________________");

    }

    private List<Contractor> getFromExcel() {
        return new ExcelReader().get();
    }

    public void migrate() {
        List<Contractor> contractors = getFromExcel();
//        save(contractors);
//        getToConsoleFromBD();
    }
}
