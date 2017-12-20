package ru.inbox.savinov_vu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    @Autowired
    private HomeService homeService;

    @Autowired
    private StreetService streetService;

    public void start() {
        streetService.add();
    }
}
