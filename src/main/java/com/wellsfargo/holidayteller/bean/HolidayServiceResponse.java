package com.wellsfargo.holidayteller.bean;

import java.util.List;

public class HolidayServiceResponse {
    private List<Holiday> holidays;

    public List<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(List<Holiday> holidays) {
        this.holidays = holidays;
    }
}
