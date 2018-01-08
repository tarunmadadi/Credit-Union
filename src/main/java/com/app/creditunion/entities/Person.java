package com.app.creditunion.entities;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1003982984289L;
	
	public Person() {}
	
	public Person(Person person) {
		if(person == null) {
			return;
		}
		this.firstName = person.firstName;
		this.lastName = person.lastName;
		this.isEligible = person.isEligible;
		this.ssn = person.ssn;
		this.zipCode = person.zipCode;
		this.ssnToUse = ssn.length() > 4 ? ssn.substring(ssn.length()-4) : ssn;
	}
	
	private String firstName;
	private String lastName;
	private String ssn;
	private String zipCode;
	private boolean isEligible;
	private String ssnToUse;
	
	
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
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
		this.ssnToUse = ssn.length() > 4 ? ssn.substring(ssn.length()-4) : ssn;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isEligible() {
		return isEligible;
	}
	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ssnToUse == null) ? 0 : ssnToUse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ssnToUse == null) {
			if (other.ssnToUse != null)
				return false;
		} else if (!ssnToUse.equals(other.ssnToUse))
			return false;
		return true;
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
			.append("ssn - ")
			.append(ssn)
			.append(", ")
			.append("zipCode - ")
			.append(zipCode)
			.append(", ")
			.append("isEligible - ")
			.append(isEligible)
			.append("]").toString();
	}
	
}
