package dotaapp;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.Hero;
import pojos.Player;

public class App {

	public static void main(String arg[]) throws IOException, InterruptedException {
		int accountId = Integer.parseInt(arg[0]);
		int numOfTopHeros = Integer.parseInt(arg[1]);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.opendota.com/api/players/"+accountId+"/heroes"))
				.build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		ObjectMapper mapper = new ObjectMapper();
		List<Player> list = mapper.readValue(response.body(), mapper.getTypeFactory().constructCollectionType(List.class, Player.class));
		HttpRequest heroRequest = HttpRequest.newBuilder()
				.uri(URI.create("https://api.opendota.com/api/heroes/"))
				.build();
		HttpResponse<String> heroResponse = client.send(heroRequest, BodyHandlers.ofString());
		List<Hero> heros = mapper.readValue(heroResponse.body(), mapper.getTypeFactory().constructCollectionType(List.class, Hero.class));
		List<Hero> output = new ArrayList<Hero>();
		for(int i =0 ; i<numOfTopHeros; i++) {
			Player player = list.get(i);
			for(Hero hero : heros) {
				if(Integer.parseInt(player.getHeroId()) == hero.getHeroId()) {
					output.add(hero);
				}
			}
		}
		System.out.print(mapper.writeValueAsString(output));
	}
}
