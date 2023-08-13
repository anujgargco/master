package com.example.spring.jenkins;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {
	Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

	@Test
	void contextLoads() {
		logger.info("Test case executed....");
		Assert.assertTrue(true);
	}

}
