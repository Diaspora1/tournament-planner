package com.diaspora.TournamentPlanner.Tournament;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TournamentController {
	
	@Autowired
	private TournamentService tournamentService;
		
	@GetMapping("/home")
	public String home(Model model) {						
		return "redirect:/tournaments";
	}	
	
	@GetMapping("/tournaments")
	public String getAllTournaments(Model model) {	
		model.addAttribute("tournaments", tournamentService.getAllTournaments());		
		return "tournaments";
	}
	
	@PostMapping("/saveTournament")		
	public String saveTournament(Tournament tournament) {
		
		tournamentService.saveTournament(tournament);
		
		return "redirect:/tournaments";
	}	
		
	@GetMapping("/tournament/{tournamentId}")
	@ResponseBody
	public Optional<Tournament> getTournament(@PathVariable Integer tournamentId) {
		return tournamentService.getTournament(tournamentId);
	}	
		
	@PostMapping("/deleteTournament/{tournamentId}")
	public String deleteTournament(@PathVariable Integer tournamentId) {
		
		Optional<Tournament> tournament = tournamentService.getTournament(tournamentId);
		if (tournament.isPresent()) {
			tournamentService.deleteTournament(tournament.get());
		}
		
		return "redirect:/tournaments";
	}		
}
