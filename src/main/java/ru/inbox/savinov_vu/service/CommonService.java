package ru.inbox.savinov_vu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.inbox.savinov_vu.commonInterfaces.CRUD;
import ru.inbox.savinov_vu.commonInterfaces.Identify;
import ru.inbox.savinov_vu.converter.MetaObjectCreator;
import ru.inbox.savinov_vu.model.MetaObject;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommonService {

    @Autowired
    private HomeService homeService;

    @Autowired
    private StreetService streetService;

    @Autowired
    private ApartmentService apartmentService;

    @Autowired
    private ContragentService contragentService;

    @Autowired
    private MetaObjectService metaObjectService;

    @Transactional
    public void start() {
        List<CRUD> services = new ArrayList<>();
        List<Identify> list = new ArrayList<>();
        services.add(streetService);
        services.add(homeService);
        services.add(apartmentService);
        services.add(contragentService);

        for (CRUD service :services) {
            list.addAll(service.getAll());
        }

        List<MetaObject> metaObjects = MetaObjectCreator.convert(list);

        metaObjectService.add(metaObjects);



        /*DataContainer dataContainer = new ExcelReader().get();
        streetService.add(dataContainer.streetMap);
        homeService.add(dataContainer.homeMap);
        apartmentService.add(dataContainer.apartmentMap);*/
    }


}
