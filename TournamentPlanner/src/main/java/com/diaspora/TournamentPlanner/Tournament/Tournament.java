package com.diaspora.TournamentPlanner.Tournament;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.diaspora.TournamentPlanner.Team.Team;

//@Entity
public class Tournament {

//	@Id
	public String tournamentId; 
	public String name;
	
	public Integer rounds;
	public Integer courts;
	public Integer teamsPerTeam;
	public List<Team> assignedTeams;
	
	private List<TournamentTeam> teams;
	
	
	//CREATE MATCHES
	public List<Match> createMatches() {
		
		List<Match> matches = new ArrayList<>();
		
		//check parameters
		if (assignedTeams.size() == 0 ||
			rounds == 0 ||
			courts == 0) {
			return null;
		};
		
		//create a tournament Team list
		teams = new ArrayList<>();	
		
	    for (int i = 0; i < assignedTeams.size(); i++) {
	    	TournamentTeam team = new TournamentTeam(); 
	    	team.teamId = assignedTeams.get(i).teamId;
	    	teams.add(team);
	    };
		
		
	    //create matches
	    int maxNumberOfMatches = rounds * courts;
	    
	    for (int i = 0; i < maxNumberOfMatches; i++) { 
	    	Match match = calculateMatch();
	    	
	    	if (match != null) {
	    		matches.add(match);
	    	} else {
	    		break;
	    	}	    	
	    };
		
		return matches;
	}
		
	
	
	//CALCULATE A MATCH
	private Match calculateMatch() {
		Match match = new Match();
		
		//find referee
		List<TournamentTeam> refereeTeams = teams;
		//sort referees by counter
		refereeTeams.sort(Comparator.comparing(TournamentTeam::getRefereeCounter));
		TournamentTeam refTeam = refereeTeams.get(0);
		//delete teams from list, if they have been referee more times than others
		refereeTeams.removeIf(s -> s.refereeCounter != refTeam.refereeCounter);
		if (refereeTeams.size() == 1) {
			//one team has not yet been referee -> pick this team
			match.setReferee(getTeamByTournamentTeam(refereeTeams.get(0)));
		}
		
		
		//find home team
		
		
		
		
		//find away team
		
		
		
		
		
		return null;
	}


	
	
	
	private Team getTeamByTournamentTeam(TournamentTeam tournamentTeam) {
		Optional<Team> team = assignedTeams.stream().filter(s -> s.teamId == tournamentTeam.teamId).findFirst();
		
		if (team.isPresent()) {
			return team.get();
		} else {
			return null;
		}
	}



	public Tournament() {
		super(); 
	}


	public Tournament(String tournamentId, String name, Integer rounds, Integer courts, Integer teamsPerTeam,
			List<Team> assignedTeams) {
		super();
		this.tournamentId = tournamentId;
		this.name = name;
		this.rounds = rounds;
		this.courts = courts;
		this.teamsPerTeam = teamsPerTeam;
		this.assignedTeams = assignedTeams;
	}


	public String getTournamentId() {
		return tournamentId;
	}


	public void setTournamentId(String tournamentId) {
		this.tournamentId = tournamentId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getRounds() {
		return rounds;
	}


	public void setRounds(Integer rounds) {
		this.rounds = rounds;
	}


	public Integer getCourts() {
		return courts;
	}


	public void setCourts(Integer courts) {
		this.courts = courts;
	}


	public Integer getTeamsPerTeam() {
		return teamsPerTeam;
	}


	public void setTeamsPerTeam(Integer teamsPerTeam) {
		this.teamsPerTeam = teamsPerTeam;
	}


	public List<Team> getTeams() {
		return assignedTeams;
	}


	public void setTeams(List<Team> assignedTeams) {
		this.assignedTeams = assignedTeams;
	}
	
		
}
