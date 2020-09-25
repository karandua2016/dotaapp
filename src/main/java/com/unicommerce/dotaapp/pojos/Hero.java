package com.unicommerce.dotaapp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;


/*
 * Pojo representing a Hero
 */
@JsonIgnoreProperties({"npc_dota_hero_antimage", "primary_attr", "attack_type","roles" ,"legs"})
@JsonPropertyOrder({"hero_id", "name", "localized_name"})
public class Hero {
	
	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalizedName() {
		return localizedName;
	}

	public void setLocalizedName(String localizedName) {
		this.localizedName = localizedName;
	}
	
	@JsonProperty("hero_id")
	@JsonSetter("id")
	int heroId;
	
	@JsonSetter("name")
	String name;
	
	@JsonProperty("localized_name")
	@JsonSetter("localized_name")
	String localizedName;

}
