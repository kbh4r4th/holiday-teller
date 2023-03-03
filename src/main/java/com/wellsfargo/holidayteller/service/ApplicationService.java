package com.wellsfargo.holidayteller.service;

import com.wellsfargo.holidayteller.bean.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class runs the process for the application by coordinating with adapter and service classes.
 */
@Component
public class ApplicationService {
    private HolidayServiceAdapter holidayServiceAdapter;

    @Autowired
    public ApplicationService(HolidayServiceAdapter serviceAdapter) {
        this.holidayServiceAdapter = serviceAdapter;
    }

    public boolean isHoliday() {
        return isHolidayToday(LocalDate.now().toString());
    }

    public boolean isHolidayToday(String date) {
        Map<Integer, List<Holiday>> holidayMap = holidayServiceAdapter.getHolidays();

        List<Holiday> list = holidayMap.get(LocalDate.parse(date).getYear());

        List<String> holidaySet = list.stream().map(Holiday::getPrettyDate).toList();

        return holidaySet.contains(date);
    }
}
