package com.example.spring.jenkins;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
        static Logger logger = LoggerFactory.getLogger(Application.class);
	@PostConstruct
	public void intt(){
		logger.info("Application has been started....");
	}

	public static void main(String[] args) {
		logger.info("Application has been executed....");
		SpringApplication.run(Application.class, args);
		logger.info("Application has been done");
	}

}
