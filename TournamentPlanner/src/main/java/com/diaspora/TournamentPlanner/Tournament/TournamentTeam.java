package com.diaspora.TournamentPlanner.Tournament;

import java.util.List;

public class TournamentTeam {

	
	public Integer teamId;
	public Integer refereeCounter;
	public Integer matchCounter;
	public List<Opponent> opponents;
	
	
	public TournamentTeam() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public TournamentTeam(Integer teamId, Integer refereeCounter, Integer matchCounter, List<Opponent> opponents) {
		super();
		this.teamId = teamId;
		this.refereeCounter = refereeCounter;
		this.matchCounter = matchCounter;
		this.opponents = opponents;
	}
	
	
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getRefereeCounter() {
		return refereeCounter;
	}
	public void setRefereeCounter(Integer refereeCounter) {
		this.refereeCounter = refereeCounter;
	}
	public Integer getMatchCounter() {
		return matchCounter;
	}
	public void setMatchCounter(Integer matchCounter) {
		this.matchCounter = matchCounter;
	}
	public List<Opponent> getOpponents() {
		return opponents;
	}
	public void setOpponents(List<Opponent> opponents) {
		this.opponents = opponents;
	}

	
}
