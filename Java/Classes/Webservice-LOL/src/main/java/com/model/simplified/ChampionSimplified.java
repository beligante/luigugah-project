package com.model.simplified;

import java.util.ArrayList;
import java.util.List;

import com.achimala.leaguelib.models.LeagueChampion;

public class ChampionSimplified {
	private String name;

	public static ChampionSimplified parse(LeagueChampion champion)
	{
		ChampionSimplified campeao = new ChampionSimplified();
		
		campeao.name = champion.getName();
		
		return campeao;
	}
	
	public static List<ChampionSimplified> parseArray(List<LeagueChampion> lista)
	{
		List<ChampionSimplified> parseado = new ArrayList<ChampionSimplified>();
		for(LeagueChampion champion : lista)
		{
			parseado.add(parse(champion));
		}
		
		return parseado;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
