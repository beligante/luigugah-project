package com.model.simplified;

import java.io.Serializable;
import java.util.List;

public class PlayingTeamSimplified implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String playerTeamType, enemyTeamType;
	private List<SumonnerSimplified> playerTeam, enemyTeam;
	private List<ChampionSimplified> bannedPlayerTeam, bannedEnemyTeam;
	
	public List<ChampionSimplified> getBannedPlayerTeam() {
		return bannedPlayerTeam;
	}
	public void setBannedPlayerTeam(List<ChampionSimplified> bannedPlayerTeam) {
		this.bannedPlayerTeam = bannedPlayerTeam;
	}
	public List<ChampionSimplified> getBannedEnemyTeam() {
		return bannedEnemyTeam;
	}
	public void setBannedEnemyTeam(List<ChampionSimplified> bannedEnemyTeam) {
		this.bannedEnemyTeam = bannedEnemyTeam;
	}
	public String getPlayerTeamTipe() {
		return playerTeamType;
	}
	public void setPlayerTeamTipe(String playerTeamTipe) {
		this.playerTeamType = playerTeamTipe;
	}
	public String getEnemyTeamType() {
		return enemyTeamType;
	}
	public void setEnemyTeamType(String enemyTeamType) {
		this.enemyTeamType = enemyTeamType;
	}
	public List<SumonnerSimplified> getPlayerTeam() {
		return playerTeam;
	}
	public void setPlayerTeam(List<SumonnerSimplified> playerTeam) {
		this.playerTeam = playerTeam;
	}
	public List<SumonnerSimplified> getEnemyTeam() {
		return enemyTeam;
	}
	public void setEnemyTeam(List<SumonnerSimplified> enemyTeam) {
		this.enemyTeam = enemyTeam;
	}

}
