package com.wellsfargo.holidayteller.service;

import com.wellsfargo.holidayteller.bean.Holiday;
import com.wellsfargo.holidayteller.bean.HolidayServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HolidayServiceAdapter {
    private final RestTemplate restTemplate;

    @Value("${holiday.service.url}")
    private String url;

    @Autowired
    public HolidayServiceAdapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<Integer, List<Holiday>> getHolidays() {
        HolidayServiceResponse response = restTemplate.getForObject(url.concat("/holidays"), HolidayServiceResponse.class);
        assert response != null;
        return response.getHolidays().stream().collect(Collectors.groupingBy(Holiday::geYear));
    }
}
