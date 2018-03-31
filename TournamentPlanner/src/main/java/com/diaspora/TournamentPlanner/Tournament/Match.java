package com.diaspora.TournamentPlanner.Tournament;

import java.util.List;

import com.diaspora.TournamentPlanner.Team.Team;

public class Match {
	
	public List<Team> homeTeam; 
	public List<Team> awayTeam;
	public Team referee;
	
	
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Match(List<Team> homeTeam, List<Team> awayTeam, Team referee) {
		super();
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.referee = referee;
	}


	public List<Team> getHomeTeam() {
		return homeTeam;
	}
	public void setHomeTeam(List<Team> homeTeam) {
		this.homeTeam = homeTeam;
	}
	public List<Team> getAwayTeam() {
		return awayTeam;
	}
	public void setAwayTeam(List<Team> awayTeam) {
		this.awayTeam = awayTeam;
	}

	public Team getReferee() {
		return referee;
	}

	public void setReferee(Team referee) {
		this.referee = referee;
	}
	
}
