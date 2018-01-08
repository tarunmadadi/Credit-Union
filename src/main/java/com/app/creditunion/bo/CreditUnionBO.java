package com.app.creditunion.bo;

import org.springframework.stereotype.Component;

import com.app.creditunion.entities.Person;
import com.app.creditunion.repository.PersonRepository;

@Component
public class CreditUnionBO {
	private PersonRepository repository;
	
	/**
	 * Constructor injection
	 * @param repository
	 */
	public CreditUnionBO(PersonRepository repository) {
		this.repository = repository;
	}
	
	public Person getPersonBySsn(String ssn) {
		return repository.getPersonBySsn(ssn);
	}
}
