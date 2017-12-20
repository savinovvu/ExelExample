package ru.inbox.savinov_vu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.inbox.savinov_vu.service.CommonService;
import ru.inbox.savinov_vu.service.ContractorService;

@SpringBootApplication
public class MigrateDataFromExelToDbApplication implements CommandLineRunner {

    @Autowired
    private ContractorService contractorService;

    @Autowired
    private CommonService commonService;

    public static void main(String[] args) {
        SpringApplication.run(MigrateDataFromExelToDbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        commonService.start();
    }
}
