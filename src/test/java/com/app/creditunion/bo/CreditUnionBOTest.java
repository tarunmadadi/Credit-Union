package com.app.creditunion.bo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.app.creditunion.entities.Person;
import com.app.creditunion.repository.PersonRepository;

@RunWith(MockitoJUnitRunner.class)
public class CreditUnionBOTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@InjectMocks
	private CreditUnionBO underTest;
	
	@Mock
	private PersonRepository mockedPersonRepository;
	
	@Mock
	private Person person;

	@Test
	public void getPersonBySsn() {

		when(mockedPersonRepository.getPersonBySsn("1234")).thenReturn(person);
		person = underTest.getPersonBySsn("1234");
		assertNotNull(person);
		
	}
}
