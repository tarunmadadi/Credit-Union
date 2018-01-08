package com.app.creditunion.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.creditunion.bo.CreditUnionBO;
import com.app.creditunion.entities.Person;
import com.app.creditunion.exception.CreditUnionException;
import com.app.creditunion.model.PersonRequest;
import com.app.creditunion.model.PersonResponse;

@RestController
public class CreditUnionRestController {
	
	private static final String TOKEN = "token";
	private static final String X_REQUEST_ID = "x-request-id";
	private static final String VALID_TOKEN = "2bndjqnuwje23h2nmnka954nk492n32m1i3n1dsr3n32";
	
	
	private static final Logger LOG = LoggerFactory.getLogger(CreditUnionRestController.class);
	
	private CreditUnionBO bo;
	
	public CreditUnionRestController(CreditUnionBO bo) {
		this.bo = bo;
	}
	
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;
	
	@PostMapping(value = "/financial-eligibility", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	public ResponseEntity<PersonResponse> financialEligibility(@RequestBody PersonRequest req) {
		
		validateRequest();
		Person person = bo.getPersonBySsn(req.getSsn());
		
		boolean isEligible = req.getFirstName().equals(person.getFirstName()) && req.getLastName().equals(person.getLastName()) && person.isEligible();
		person.setEligible(isEligible);
		return new ResponseEntity<PersonResponse>(new PersonResponse(person),HttpStatus.OK);
	}

	@ExceptionHandler(CreditUnionException.class)
	public ResponseEntity<PersonResponse> handleException(CreditUnionException e) {
		return new ResponseEntity<>(new PersonResponse(), e.getStatus());
	}
	
	private void validateRequest() {
		String token = request.getHeader(TOKEN);
		String xRequestId = request.getHeader(X_REQUEST_ID);
		
		response.addHeader(X_REQUEST_ID, xRequestId);
		
		LOG.info("Validating request - token - [{}], x-request-id - [{}]", token, xRequestId);
		if(!VALID_TOKEN.equals(token)) {
			LOG.error("Invalid token passed - [{}]", token);
			throw new CreditUnionException(HttpStatus.FORBIDDEN);
		}
		
	}
}
