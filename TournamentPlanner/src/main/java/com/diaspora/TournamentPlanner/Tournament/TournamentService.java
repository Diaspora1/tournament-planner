package com.diaspora.TournamentPlanner.Tournament;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
	
	@Autowired
	private TournamentDao tournamentDao;
	
	public List<Tournament> getAllTournaments() {			
		List<Tournament> tournament = new ArrayList<>(); 
		tournamentDao.findAll().forEach(tournament::add);		
		return tournament;
	}
	
	public void saveTournament(Tournament tournament) {
		tournamentDao.save(tournament);
	}	
		
	public Optional<Tournament> getTournament(Integer tournamentId) {
		return tournamentDao.findById(tournamentId);
	}	
	
	public void deleteTournament(Tournament tournament) {
		tournamentDao.delete(tournament);
	}		
	
}
