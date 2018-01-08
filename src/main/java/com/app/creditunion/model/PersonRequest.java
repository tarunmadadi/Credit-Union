package com.app.creditunion.model;

import java.io.Serializable;

public class PersonRequest implements Serializable {
	private static final long serialVersionUID = 1003982984289L;
	
	private String firstName;
	private String lastName;
	private String ssn;
	private String zipCode;

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
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
			.append("]").toString();
	}
	
}
