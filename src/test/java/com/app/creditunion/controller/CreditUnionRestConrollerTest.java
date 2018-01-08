package com.app.creditunion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.app.creditunion.bo.CreditUnionBO;
import com.app.creditunion.entities.Person;
import com.app.creditunion.exception.CreditUnionException;
import com.app.creditunion.model.PersonRequest;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreditUnionRestConrollerTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Mock
	private CreditUnionBO mockedCreditUnionBO;
	
	@Mock
	private HttpServletRequest mockedRequest;

	@Mock
	private HttpServletResponse mockedResponse;
	
	@Mock
	private PersonRequest mockedPersonRequest;
	
	@InjectMocks
	private CreditUnionRestController  underTest;
	
	@Mock
	private Person mockedPerson;
	
	@Before
	public void setup() {
		ReflectionTestUtils.setField(underTest, "request", mockedRequest);
		ReflectionTestUtils.setField(underTest, "response", mockedResponse);
	}
	@Test
	public void financialEligibilityWithoutException() {
		when(mockedPersonRequest.getSsn()).thenReturn("1234");
		when(mockedCreditUnionBO.getPersonBySsn("1234")).thenReturn(mockedPerson);
		
		 when(mockedRequest.getHeader("token")).thenReturn("2bndjqnuwje23h2nmnka954nk492n32m1i3n1dsr3n32");
		 when(mockedRequest.getHeader("x-request-id")).thenReturn("htq3sb3h23h2j43k19j1k129tj2o93n13k12j");
		 when(mockedPersonRequest.getFirstName()).thenReturn("virtusa");
		
		ResponseEntity responseEntity = underTest.financialEligibility(mockedPersonRequest);
		assertNotNull(responseEntity);
	}
	
	@Test
	public void financialEligibilityWithException() {
		when(mockedPersonRequest.getSsn()).thenReturn("1234");
		when(mockedCreditUnionBO.getPersonBySsn("1234")).thenReturn(mockedPerson);
		
		 when(mockedRequest.getHeader("token")).thenReturn("bndjqnuwje23h2nmnka954nk492n32m1i3n1dsr3n32");
		 when(mockedRequest.getHeader("x-request-id")).thenReturn("htq3sb3h23h2j43k19j1k129tj2o93n13k12j");
		 when(mockedPersonRequest.getFirstName()).thenReturn("virtusa");
		
		 exception.expect(CreditUnionException.class);
		 underTest.financialEligibility(mockedPersonRequest);
		
	}
	
	@Test
	public void handleException() {
		
		ResponseEntity responseEntity = underTest.handleException(new CreditUnionException());
		assertNotNull(responseEntity);
		verifyNoMoreInteractions(mockedCreditUnionBO);
	}

}
