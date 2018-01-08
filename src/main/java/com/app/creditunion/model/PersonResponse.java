package com.app.creditunion.model;

import java.io.Serializable;

import com.app.creditunion.entities.Person;
/**
 * This class is the response model of the person related operations
 * @author Tarun
 *
 */
public class PersonResponse implements Serializable {
	private static final long serialVersionUID = 10039857489332L;

	private static final String APPROVAL = "APPROVED";
	private static final String DENIAL = "DENIED";
	
	private String firstName;
	private String lastName;
	private String eligibility;
	
	/**
	 * Making default constructor available for JSON parsing
	 */
	public PersonResponse() {
		this(null, null, false);
	}
	/**
	 * Creating this constructor so that a response can be created straight away as soon as a person is available
	 * @param person
	 */
	public PersonResponse(Person person) {
		this(person.getFirstName(), person.getLastName(), person.isEligible());
	}
	/**
	 * Also making this constructor available for future use
	 * @param firstName
	 * @param lastName
	 * @param isEligible
	 */
	public PersonResponse(String firstName, String lastName, boolean isEligible) {
		this.eligibility = isEligible ? APPROVAL : DENIAL;
		
		if(!isEligible) {
			//Not constructing any further
			return;
		}
		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEligibility() {
		return eligibility;
	}
	
	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append("Person [")
			.append("firstName - ")
			.append(firstName)
			.append(", ")
			.append("lastName - ")
			.append(lastName)
			.append(", ")
			.append("isEligible - ")
			.append(eligibility)
			.append("]").toString();
	}
}
