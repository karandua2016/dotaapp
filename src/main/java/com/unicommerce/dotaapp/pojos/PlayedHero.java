/**
 * @author Karan Dua
 */

package com.unicommerce.dotaapp.pojos;

import com.fasterxml.jackson.annotation.JsonSetter;



/*
 * Pojo representing a hero played by a user. Also used for Json Deserialization.
 */
public class PlayedHero {

	@JsonSetter("hero_id")
	String heroId;
	
	@JsonSetter("last_played")
	long lastPlayed;
	
	@JsonSetter("games")
	int games;
	
	@JsonSetter("win")
	int win;
	
	@JsonSetter("with_games")
	int withGames;
	
	@JsonSetter("with_win")
	int withWin;
	
	@JsonSetter("against_games")
	int againstGames;
	
	@JsonSetter("against_win")
	int againstWin;
	
	public String getHeroId() {
		return heroId;
	}
	public void setHeroId(String heroId) {
		this.heroId = heroId;
	}
	public long getLastPlayed() {
		return lastPlayed;
	}
	public void setLastPlayed(long lastPlayed) {
		this.lastPlayed = lastPlayed;
	}
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getWithGames() {
		return withGames;
	}
	public void setWithGames(int withGames) {
		this.withGames = withGames;
	}
	public int getWithWin() {
		return withWin;
	}
	public void setWithWin(int withWin) {
		this.withWin = withWin;
	}
	public int getAgainstGames() {
		return againstGames;
	}
	public void setAgainstGames(int againstGames) {
		this.againstGames = againstGames;
	}
	public int getAgainstWin() {
		return againstWin;
	}
	public void setAgainstWin(int againstWin) {
		this.againstWin = againstWin;
	}
	
	
}
