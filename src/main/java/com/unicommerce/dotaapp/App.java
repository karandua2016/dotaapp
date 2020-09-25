package com.unicommerce.dotaapp;
/**
 * @author Karan Dua
 */


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicommerce.dotaapp.exceptions.ConnectionException;
import com.unicommerce.dotaapp.pojos.Hero;
import com.unicommerce.dotaapp.pojos.PlayedHero;
import com.unicommerce.dotaapp.services.DotaService;

public class App {

	final static int NUM_TOP_HEROS = 3;
	static ObjectMapper mapper = new ObjectMapper();
	static Logger logger = Logger.getLogger(App.class.getName());
	
	public static void main(String arg[]){
		
		// Get account id parameter
		int accountId = Integer.parseInt(arg[0]);
		
		//Intialize the custom Dota Service
		DotaService service = new DotaService();
		List<PlayedHero> playedHero = null;
		List<Hero> heros = null;
		try {
			
			// Use instance of the DotaService to get all played heros by the account holder
			logger.info("Getting details of all heros played by the account holder");
			playedHero = service.getHerosByAccount(accountId);
			
			// Get all the heros from the service
			logger.info("Getting the list of all the available heros");
			heros = service.getAllHeros();
		} catch (IOException | InterruptedException | ConnectionException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		List<Hero> output = new ArrayList<Hero>();
		
		logger.info("Generating required results");
		// Search for the details of the top Heros
		for(int i = 0 ; i < NUM_TOP_HEROS; i++) {
			PlayedHero player = playedHero.get(i);
			for(Hero hero : heros) {
				if(Integer.parseInt(player.getHeroId()) == hero.getHeroId()) {
					output.add(hero);
					break;
				}
			}
		}
		try {
			// Pretty Print the result
			System.out.print(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(output));
		} catch (JsonProcessingException e) {
			System.exit(0);
		}
	}
}
