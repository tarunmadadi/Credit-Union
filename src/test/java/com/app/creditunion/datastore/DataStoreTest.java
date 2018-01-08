package com.app.creditunion.datastore;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import org.mockito.runners.MockitoJUnitRunner;


import com.app.creditunion.entities.Person;

@RunWith(MockitoJUnitRunner.class)
public class DataStoreTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	
	private Person person;
	
	@Test
	public void getPersonList() {
	     List<Person> personList = DataStore.getPersonList();
		assertNotNull(personList);
	}
	
	@Test
	public  void add() {
		
		boolean result = DataStore.add(person);
		assertTrue(result);
		
		 result = DataStore.add(person);
		assertFalse(result);
		
		
	}
	
	
}
