package com.app.creditunion.repository;

import java.util.ArrayList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.api.mockito.PowerMockito;

import com.app.creditunion.datastore.DataStore;
import com.app.creditunion.entities.Person;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(DataStore.class )
public class PersonRepositoryTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Mock
	private Person mockedPerson;
	
	@InjectMocks
	private PersonRepository underTest;
	
	
	@Test
	public void addPersonSuccessfully() {
		PowerMockito.mockStatic(DataStore.class);
		PowerMockito.when(DataStore.add(mockedPerson)).thenReturn(true);
		boolean result = underTest.addPerson(mockedPerson);
		assertTrue(result);
	}
	
	@Test
	public void addPersonFailure() {
		PowerMockito.mockStatic(DataStore.class);
		PowerMockito.when(DataStore.add(mockedPerson)).thenReturn(false);
		boolean result = underTest.addPerson(mockedPerson);
		assertFalse(result);
	}
	
	@Test
	public void getPersonBySsn() {
		PowerMockito.mockStatic(DataStore.class);
		PowerMockito.when(DataStore.getPersonList()).thenReturn(new ArrayList<Person>());
		Person person = underTest.getPersonBySsn("1234");
		assertNull(person);
	}
}
