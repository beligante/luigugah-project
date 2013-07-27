package com.model.simplified;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.achimala.leaguelib.connection.LeagueConnection;
import com.achimala.leaguelib.errors.LeagueException;
import com.achimala.leaguelib.models.LeagueSummoner;
import com.achimala.leaguelib.models.LeagueSummonerLeagueStats;
import com.achimala.leaguelib.services.GameService;
import com.achimala.leaguelib.services.LeaguesService;
import com.achimala.leaguelib.services.PlayerStatsService;
import com.achimala.leaguelib.services.SummonerService;
public class SumonnerSimplified implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private long acconuntId, sumonnerId, wins, elo;

	private String sumonnerName, seasonOneTier, seasonTwoTier, name, tier, rank;
	public static LeagueConnection c = null;

	public static SumonnerSimplified parseLeagueSumonner(LeagueSummoner sumonnerBase)
	{ 
		SumonnerSimplified sumonnerSimplified = new SumonnerSimplified();
		if(c != null)
		{
			System.out.println("Entrou");
			SummonerService summonerService = c.getSummonerService();
			LeaguesService leagueSummoner = c.getLeaguesService();
			PlayerStatsService playerStatsService = c.getPlayerStatsService();
			GameService gameService = c.getGameService();
			
			try {
				summonerService.fillPublicSummonerData(sumonnerBase);
				leagueSummoner.fillSoloQueueLeagueData(sumonnerBase);
				playerStatsService.fillRankedStats(sumonnerBase);
				gameService.fillActiveGameData(sumonnerBase);
				
			} catch (LeagueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		
		sumonnerSimplified.sumonnerName = sumonnerBase.getName();
		sumonnerSimplified.acconuntId = sumonnerBase.getAccountId();
		sumonnerSimplified.sumonnerId = sumonnerBase.getId();
		sumonnerSimplified.seasonOneTier = sumonnerBase.getProfileInfo().getSeasonOneTier().toString();
		sumonnerSimplified.seasonTwoTier = sumonnerBase.getProfileInfo().getSeasonTwoTier().toString();

        LeagueSummonerLeagueStats stats = sumonnerBase.getLeagueStats();
        if(stats != null) {
            sumonnerSimplified.name = stats.getLeagueName();
            sumonnerSimplified.tier = stats.getTier().toString();
            sumonnerSimplified.rank = stats.getRank().toString();
            sumonnerSimplified.wins = stats.getWins();
            sumonnerSimplified.elo = stats.getApproximateElo();
        } else {
            System.out.println("NOT IN LEAGUE");
        }
        
        return sumonnerSimplified;
	}
	
	public static List<SumonnerSimplified> parseArray(List<LeagueSummoner> lista){
		List<SumonnerSimplified> parseado = new ArrayList<SumonnerSimplified>();
		
		for(LeagueSummoner sumonner : lista)
		{
			parseado.add(parseLeagueSumonner(sumonner));
		}
		
		return parseado;
	}
	
	public long getAcconuntId() {
		return acconuntId;
	}

	public void setAcconuntId(long acconuntId) {
		this.acconuntId = acconuntId;
	}

	public long getSumonnerId() {
		return sumonnerId;
	}

	public void setSumonnerId(long sumonnerId) {
		this.sumonnerId = sumonnerId;
	}

	public String getSeasonOneTier() {
		return seasonOneTier;
	}

	public void setSeasonOneTier(String seasonOneTier) {
		this.seasonOneTier = seasonOneTier;
	}

	public String getSeasonTwoTier() {
		return seasonTwoTier;
	}

	public void setSeasonTwoTier(String seasonTwoTier) {
		this.seasonTwoTier = seasonTwoTier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public long getWins() {
		return wins;
	}

	public void setWins(long wins) {
		this.wins = wins;
	}

	public long getElo() {
		return elo;
	}

	public void setElo(long elo) {
		this.elo = elo;
	}

	public LeagueConnection getC() {
		return c;
	}

	public void setC(LeagueConnection c) {
		this.c = c;
	}

	public String getSumonnerName() {
		return sumonnerName;
	}

	public void setSumonnerName(String sumonnerName) {
		this.sumonnerName = sumonnerName;
	}
}

