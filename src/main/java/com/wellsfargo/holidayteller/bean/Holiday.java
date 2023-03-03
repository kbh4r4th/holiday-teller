package com.wellsfargo.holidayteller.bean;

import java.time.LocalDate;

public class Holiday {
    private String name;

    private String prettyDate;

    private String dayOfWeek;

    private String observedOn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrettyDate() {
        return prettyDate;
    }

    public void setPrettyDate(String prettyDate) {
        this.prettyDate = prettyDate;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getObservedOn() {
        return observedOn;
    }

    public void setObservedOn(String observedOn) {
        this.observedOn = observedOn;
    }

    public int geYear() {
        return LocalDate.parse(observedOn).getYear();
    }

}
