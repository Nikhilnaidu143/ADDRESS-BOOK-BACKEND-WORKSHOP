package com.workshop.addressbookbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AddressBookBackendApplication {

	/*** Main method. ***/
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AddressBookBackendApplication.class, args);
		log.info("Address Book App started in {} Environmet.", context.getEnvironment().getProperty("environment"));
	}

}
