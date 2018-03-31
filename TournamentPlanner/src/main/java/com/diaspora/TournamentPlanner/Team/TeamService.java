package com.diaspora.TournamentPlanner.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	
	@Autowired
	private TeamDao teamDao;
	
	
	public List<Team> getAllTeams() {		
		
		//addTeam(new Team("testA"));
		
		List<Team> teams = new ArrayList<>(); 
		teamDao.findAll().forEach(teams::add);		
		return teams;
	}
	
	public void saveTeam(Team team) {
		teamDao.save(team);
	}	
		
	public Optional<Team> getTeam(Integer teamId) {
		return teamDao.findById(teamId);
	}	
	
	public void deleteTeam(Team team) {
		teamDao.delete(team);
	}		
	
}
