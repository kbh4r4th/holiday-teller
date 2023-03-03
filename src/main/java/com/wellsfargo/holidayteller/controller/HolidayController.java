package com.wellsfargo.holidayteller.controller;

import com.wellsfargo.holidayteller.service.ApplicationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolidayController {
    private final ApplicationService applicationService;

    public HolidayController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(path = "/isholiday", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean isHoliday() {
        return applicationService.isHoliday();
    }
}
