package com.app.creditunion;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.creditunion.datastore.DataStore;

@SpringBootApplication
public class CreditUnionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditUnionApplication.class, args);
	}
	
	@PostConstruct
	public void initDataStore() {
		DataStore.init();
	}
}
