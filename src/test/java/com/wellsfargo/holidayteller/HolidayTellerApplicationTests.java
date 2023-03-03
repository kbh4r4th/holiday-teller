package com.wellsfargo.holidayteller;

import com.wellsfargo.holidayteller.service.ApplicationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class HolidayTellerApplicationTests {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ApplicationService applicationService;

	@Test
	void isHolidayTodayTest() {
		Assertions.assertTrue(applicationService.isHolidayToday("2023-01-01"));
		Assertions.assertTrue(applicationService.isHolidayToday("2021-05-31"));
	}

	@Test
	void isNotHolidayTodayTest() {
		Assertions.assertFalse(applicationService.isHolidayToday("2023-03-03"));
		Assertions.assertFalse(applicationService.isHolidayToday("2021-06-18"));
	}
}
