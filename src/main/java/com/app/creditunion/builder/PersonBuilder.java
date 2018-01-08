package com.app.creditunion.builder;

import com.app.creditunion.entities.Person;
/**
 * Creating this builder Class for Person so that hard coded data can be populated in the repository class
 *
 */

public class PersonBuilder implements Builder<Person> {
	
	private Person person;
	
	/**
	 * Constructs a Builder instance
	 * @return
	 */
	public static PersonBuilder newBuilder() {
		return new PersonBuilder();
	}
	
	private PersonBuilder () {
		person = new Person();
	}
	
	public PersonBuilder withFirstName(String firstName) {
		person.setFirstName(firstName);
		return this;
	}
	public PersonBuilder withLastName(String lastName) {
		person.setLastName(lastName);
		return this;
	}
	public PersonBuilder withSsn(String ssn) {
		person.setSsn(ssn);
		return this;
	}
	
	public PersonBuilder withZipCode(String zipCode) {
		person.setZipCode(zipCode);
		return this;
	}
	
	public PersonBuilder withEligibility(boolean isEligible) {
		person.setEligible(isEligible);
		return this;
	}
	
	/**
	 * Returns the constructed Person instance
	 */
	@Override
	public Person build() {
		return person;
	}

}
