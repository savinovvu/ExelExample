package ru.inbox.savinov_vu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.exel.ExcelReader;
import ru.inbox.savinov_vu.to.DataContainer;

import javax.transaction.Transactional;

@Service
public class CommonService {

    @Autowired
    private HomeService homeService;

    @Autowired
    private StreetService streetService;

    @Autowired
    private ApartmentService apartmentService;

    @Transactional
    public void start() {
        DataContainer dataContainer = new ExcelReader().get();
        streetService.add(dataContainer.streetMap);
        homeService.add(dataContainer.homeMap);
        apartmentService.add(dataContainer.apartmentMap);
    }


}
