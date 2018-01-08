package com.app.creditunion.datastore;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.app.creditunion.builder.PersonBuilder;
import com.app.creditunion.entities.Person;

/**
 * This class is the underlying data storage of the application
 *
 */
public final class DataStore {
	private static final Logger LOG = LoggerFactory.getLogger(DataStore.class);
	
	private static final List<Person> personList = new ArrayList<>();
	
	private DataStore() {}
	
	/**
	 * Adds a person instance to the {@link personList}
	 * @param person
	 * @return
	 */
	public static boolean add(Person person) {
		if(personList.contains(person)) {
			return false;
		}
		return personList.add(person);
	}
	/**
	 * Returns a copy of {@link personList}
	 * @return
	 */
	public static List<Person> getPersonList() {
		
		return copyOf(personList);
		
	}
	
	/**
	 * Creating a copy of the original list so that the actual data do not get changed/tampered
	 * @param list
	 * @return
	 */
	private static List<Person> copyOf(List<Person> list) {
		List<Person> copiedList = new ArrayList<>();
		for(Person p : list) {
			copiedList.add(new Person(p));
		}
		
		return copiedList;
	}
	
	/**
	 * Initial storage with 6 person instances
	 */
	public static void init() {
		LOG.info("Initializing data store...");
		
		personList.add(PersonBuilder.newBuilder()
							.withFirstName("Kathy")
							.withLastName("Woods")
							.withSsn("423456900")
							.withZipCode("56789")
							.withEligibility(false)
							.build());
		personList.add(PersonBuilder.newBuilder()
							.withFirstName("Christina")
							.withLastName("Kuntz")
							.withSsn("23980998")
							.withZipCode("78907")
							.withEligibility(true)
							.build());
		personList.add(PersonBuilder.newBuilder()
							.withFirstName("Nick")
							.withLastName("Maddison")
							.withSsn("675433612")
							.withZipCode("90987")
							.withEligibility(true)
							.build());
		personList.add(PersonBuilder.newBuilder()
							.withFirstName("Chris")
							.withLastName("Lewis")
							.withSsn("657493930")
							.withZipCode("60041")
							.withEligibility(false)
							.build());
		personList.add(PersonBuilder.newBuilder()
							.withFirstName("Cavin")
							.withLastName("Cooper")
							.withSsn("768590498")
							.withZipCode("67894")
							.withEligibility(true)
							.build());
		personList.add(PersonBuilder.newBuilder()
							.withFirstName("Steve")
							.withLastName("Smith")
							.withSsn("768959493")
							.withZipCode("58604")
							.withEligibility(false)
							.build());
	}
}
