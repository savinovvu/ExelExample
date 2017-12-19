package ru.inbox.savinov_vu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractorService {

    @Autowired
    private ContractorRepository repository;

    private void save(List<Contractor> contractors) {
        repository.save(contractors);
    }

    private void getToConsoleFromBD() {
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        List<Contractor> contractors = repository.findAll();
        System.out.println(contractors.size());
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
    }

    private List<Contractor> getFromExcel() {
        return new ExcelReader().get();
    }

    public void migrate() {
//        List<Contractor> contractors = getFromExcel();
//        save(contractors);
        getToConsoleFromBD();
    }
}
