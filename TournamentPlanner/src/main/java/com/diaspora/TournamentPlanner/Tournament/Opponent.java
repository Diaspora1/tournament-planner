package com.diaspora.TournamentPlanner.Tournament;

public class Opponent {

	
	public Integer teamId;
	public Integer teammateCounter;
	public Integer opponentCounter;
	
	
	public Opponent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Opponent(Integer teamId, Integer teammateCounter, Integer opponentCounter) {
		super();
		this.teamId = teamId;
		this.teammateCounter = teammateCounter;
		this.opponentCounter = opponentCounter;
	}


	public Integer getTeamId() {
		return teamId;
	}


	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}


	public Integer getTeammateCounter() {
		return teammateCounter;
	}


	public void setTeammateCounter(Integer teammateCounter) {
		this.teammateCounter = teammateCounter;
	}


	public Integer getOpponentCounter() {
		return opponentCounter;
	}


	public void setOpponentCounter(Integer opponentCounter) {
		this.opponentCounter = opponentCounter;
	}	
	
	
	
}
