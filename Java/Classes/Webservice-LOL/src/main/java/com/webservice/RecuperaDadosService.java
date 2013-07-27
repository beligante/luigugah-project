package com.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.achimala.leaguelib.connection.LeagueConnection;
import com.achimala.leaguelib.connection.LeagueServer;
import com.achimala.leaguelib.errors.LeagueException;
import com.achimala.leaguelib.models.LeagueGame;
import com.achimala.leaguelib.models.LeagueSummoner;
import com.achimala.leaguelib.services.GameService;
import com.achimala.leaguelib.services.LeaguesService;
import com.achimala.leaguelib.services.PlayerStatsService;
import com.achimala.leaguelib.services.SummonerService;
import com.connection.ConnectionManager;
import com.google.gson.Gson;
import com.model.simplified.ChampionSimplified;
import com.model.simplified.PlayingTeamSimplified;
import com.model.simplified.SumonnerSimplified;
import com.sun.jersey.spi.resource.Singleton;

@Path("/lol")
@Singleton
public class RecuperaDadosService extends Application{
	
	final LeagueConnection c;
	public RecuperaDadosService()
	{
		System.out.println("Criou");
		final String user = "Thyoity";
		final String password = "thiago1994";
		final String gameVersion = "3.9.xx";
		
		c = new ConnectionManager().getLeagueConnection(LeagueServer.BRAZIL, user, password, gameVersion);
	}
	
	@GET
	@Path("/recupera")
	@Produces(MediaType.APPLICATION_JSON)
	public String recupera(@QueryParam("server") String server, @QueryParam("summoner") String summoner){
		
		summoner = summoner.replace("%20", " ");
		
		
		
		LeagueSummoner sSumonner;
		
		if(c != null){
			
			SummonerService summonerService = c.getSummonerService();
			LeaguesService leagueSummoner = c.getLeaguesService();
			PlayerStatsService playerStatsService = c.getPlayerStatsService();
			GameService gameService = c.getGameService();
			
			try{
				
				SumonnerSimplified.c = c;
				sSumonner = c.getSummonerService().getSummonerByName(summoner);
				summonerService.fillPublicSummonerData(sSumonner);
				leagueSummoner.fillSoloQueueLeagueData(sSumonner);
				playerStatsService.fillRankedStats(sSumonner);
				gameService.fillActiveGameData(sSumonner);
				
				LeagueGame game = sSumonner.getActiveGame();
				PlayingTeamSimplified jogo = null;
				if(game != null)
				{
					jogo = new PlayingTeamSimplified();
					
					jogo.setPlayerTeamTipe(game.getPlayerTeamType().toString());
					jogo.setEnemyTeamType(game.getEnemyTeamType().toString());
					jogo.setPlayerTeam(SumonnerSimplified.parseArray(game.getPlayerTeam()));
					jogo.setEnemyTeam(SumonnerSimplified.parseArray(game.getEnemyTeam()));
					jogo.setBannedEnemyTeam(ChampionSimplified.parseArray(game.getBannedChampionsForTeam(game.getEnemyTeamType())));
					jogo.setBannedPlayerTeam(ChampionSimplified.parseArray(game.getBannedChampionsForTeam(game.getPlayerTeamType())));
				}
				
				List<Object> resultado =  new ArrayList<Object>();
				resultado.add(SumonnerSimplified.parseLeagueSumonner((sSumonner)));
				if(jogo != null)
				{
					resultado.add(jogo);
				}			
				
				return new Gson().toJson(resultado);
				
			
			} catch (LeagueException e) {
				
				e.printStackTrace();
			}
		}		
		return null;	
	}
}
