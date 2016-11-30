package com.danielrocha.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.danielrocha.repository.PersonRepository;

import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;

@Endpoint
public class CountryEndpoint {
	
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private PersonRepository personRepository;

	@Autowired
	public CountryEndpoint(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		//response.setCountry(personRepository.findCountry(request.getName()));

		return response;
	}
	
}