/**
 * @author Karan Dua
 */

package com.unicommerce.dotaapp.services;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicommerce.dotaapp.exceptions.ConnectionException;
import com.unicommerce.dotaapp.pojos.Hero;
import com.unicommerce.dotaapp.pojos.PlayedHero;


/*
 * Service class for calling the APIs
 */
public class DotaService {

	HttpClient client;
	ObjectMapper mapper;
	
	final String heroRequestUrl = "https://api.opendota.com/api/heroes/";
	final String playedHeroRequestUrl = "https://api.opendota.com/api/players/%d/heroes";

	public DotaService() {
		client = HttpClient.newHttpClient();
		mapper = new ObjectMapper();
	}

	public List<PlayedHero> getHerosByAccount(int accountId) throws IOException, InterruptedException, ConnectionException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(String.format(playedHeroRequestUrl, accountId)))
				.build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch(ConnectException e) {
			throw new ConnectException("Unable to send request. Please check URL and/or Internet");
		}
		isResponseOK(response);
		List<PlayedHero> list = mapper.readValue(response.body(), mapper.getTypeFactory().constructCollectionType(List.class, PlayedHero.class));
		return list;
	}

	public List<Hero> getAllHeros() throws IOException, InterruptedException, ConnectionException {
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(heroRequestUrl))
				.build();
		HttpResponse<String> response = null;
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch(ConnectException e) {
			throw new ConnectException("Unable to send request. Please check URL and/or Internet");
		}
		isResponseOK(response);
		List<Hero> heros = mapper.readValue(response.body(), mapper.getTypeFactory().constructCollectionType(List.class, Hero.class));
		return heros;
	}

	private void isResponseOK(HttpResponse<String> response) throws ConnectionException {

		if(response.statusCode() == 404) {
			throw new ConnectionException("Not Found");
		} else if(response.statusCode() == 400) {
			throw new ConnectionException("Bad Request");
		} else if(response.statusCode() == 403) {
			throw new ConnectionException("Forbidden");
		} else if(response.statusCode() == 500) {
			throw new ConnectionException("Internal Server Error");
		} else if(response.statusCode() == 503) {
			throw new ConnectionException("Service Unavailable");
		} else if(response.statusCode() == 504) {
			throw new ConnectionException("Gateway Timeout");
		}

	}

}
