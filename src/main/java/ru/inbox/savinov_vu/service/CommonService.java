package ru.inbox.savinov_vu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CommonService {

    @Autowired
    private HomeService homeService;

    @Autowired
    private StreetService streetService;

    @Transactional
    public void start() {
        streetService.add();
        streetService.get();
    }
}
