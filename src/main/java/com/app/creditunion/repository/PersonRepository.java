package com.app.creditunion.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.app.creditunion.builder.PersonBuilder;
import com.app.creditunion.datastore.DataStore;
import com.app.creditunion.entities.Person;

@Component
public class PersonRepository {	
	/**
	 * Returns true if the person is added, false if a person exists with same SSN
	 * @param person
	 * @return
	 */
	public boolean addPerson(Person person) {
		return DataStore.add(person);
	}
	/**
	 * Returns a person instance have provided SSN. Returns null if no such instance is found
	 * @param ssn
	 * @return
	 */
	public Person getPersonBySsn(String ssn) {
		Person person = PersonBuilder.newBuilder().withSsn(ssn).build();
		List<Person> list = DataStore.getPersonList();
		return list.contains(person) ? list.get(list.indexOf(person)) : null;
	}
}
