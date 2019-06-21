package com.diaspora.TournamentPlanner.Tournament;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.format.annotation.DateTimeFormat;

import com.diaspora.TournamentPlanner.Team.Team;

@Entity
public class Tournament {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer tournamentId;
	
	public String name;
	public String location;
	
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	public Date tournamentDate;
	
	public Integer rounds;
	public Integer courts;
	public Integer teamsPerTeam;
	public Integer playerPerTeam;
	public Integer maxSubsequentRoundsPerTeam;
	
	@Column
    @ElementCollection
	public List<Team> assignedTeams;
	
	@Column(updatable = false)
	public Date createdDate;
		
	public Date lastModifiedDate;
		
	
/*	@Column
    @ElementCollection(targetClass=TournamentTeam.class)
	private List<TournamentTeam> teams;*/
	
	/*
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

*/
	
	
	
/*	private Team getTeamByTournamentTeam(TournamentTeam tournamentTeam) {
		Optional<Team> team = assignedTeams.stream().filter(s -> s.teamId == tournamentTeam.teamId).findFirst();
		
		if (team.isPresent()) {
			return team.get();
		} else {
			return null;
		}
	}
*/


	public Tournament() {
		super(); 
	}



	
    public Tournament(Integer tournamentId, String name, String location, Date tournamentDate, Integer rounds,
			Integer courts, Integer teamsPerTeam, Integer playerPerTeam, Integer maxSubsequentRoundsPerTeam,
			List<Team> assignedTeams, Date createdDate, Date lastModifiedDate) {
		super();
		this.tournamentId = tournamentId;
		this.name = name;
		this.location = location;
		this.tournamentDate = tournamentDate;
		this.rounds = rounds;
		this.courts = courts;
		this.teamsPerTeam = teamsPerTeam;
		this.playerPerTeam = playerPerTeam;
		this.maxSubsequentRoundsPerTeam = maxSubsequentRoundsPerTeam;
		this.assignedTeams = assignedTeams;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}



	@PrePersist
    public void onPrePersist() {
        setCreatedDate(new Date());
        setLastModifiedDate(new Date());
    }
      
    @PreUpdate
    public void onPreUpdate() {
    	setLastModifiedDate(new Date());
    }		


	public Integer getTournamentId() {
		return tournamentId;
	}


	public void setTournamentId(String tournamentId) {
		this.tournamentId = Integer.parseInt(tournamentId);
	}

	

	public List<Team> getAssignedTeams() {
		return assignedTeams;
	}



	public void setAssignedTeams(List<Team> assignedTeams) {
		this.assignedTeams = assignedTeams;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}



	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
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



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public Date getTournamentDate() {
		return tournamentDate;
	}



	public void setTournamentDate(Date tournamentDate) {
		this.tournamentDate = tournamentDate;
	}



	public Integer getPlayerPerTeam() {
		return playerPerTeam;
	}



	public void setPlayerPerTeam(Integer playerPerTeam) {
		this.playerPerTeam = playerPerTeam;
	}



	public Integer getMaxSubsequentRoundsPerTeam() {
		return maxSubsequentRoundsPerTeam;
	}



	public void setMaxSubsequentRoundsPerTeam(Integer maxSubsequentRoundsPerTeam) {
		this.maxSubsequentRoundsPerTeam = maxSubsequentRoundsPerTeam;
	}
	
	
	
		
}
