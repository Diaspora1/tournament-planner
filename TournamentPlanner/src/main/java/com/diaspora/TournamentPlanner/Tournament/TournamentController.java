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
		
	@GetMapping({"/volleymatch", "/volleymatch/home"})
	public String home(Model model) {						
		return "redirect:/volleymatch/tournaments";
	}	
	
	@GetMapping("/volleymatch/tournaments")
	public String getAllTournaments(Model model) {	
		model.addAttribute("tournaments", tournamentService.getAllTournaments());		
		return "tournaments";
	}
	
	@GetMapping("/volleymatch/tournaments/{tournamentId}")
	public String getTournamentDetails(@PathVariable Integer tournamentId, Model model) {
		
		Optional<Tournament> tournament = tournamentService.getTournament(tournamentId);
		if(tournament.isPresent()) {
			model.addAttribute("tournament", tournament.get()); 
			return "tournamentDetails";
		} else {
			return "redirect:/volleymatch";
		}
		
	}		
	
	@PostMapping("/volleymatch/saveTournament")		
	public String saveTournament(Tournament tournament) {
		
		tournamentService.saveTournament(tournament);
		
		return "redirect:/volleymatch/tournaments";
	}	
		
	@GetMapping("/volleymatch/tournament/{tournamentId}")
	@ResponseBody
	public Optional<Tournament> getTournament(@PathVariable Integer tournamentId) {
		return tournamentService.getTournament(tournamentId);
	}	
		
	@PostMapping("/volleymatch/deleteTournament/{tournamentId}")
	public String deleteTournament(@PathVariable Integer tournamentId) {
		
		Optional<Tournament> tournament = tournamentService.getTournament(tournamentId);
		if (tournament.isPresent()) {
			tournamentService.deleteTournament(tournament.get());
		}
		
		return "redirect:/volleymatch/tournaments";
	}		
}
