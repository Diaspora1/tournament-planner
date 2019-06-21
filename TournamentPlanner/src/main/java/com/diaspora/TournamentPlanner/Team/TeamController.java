package com.diaspora.TournamentPlanner.Team;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
			
	@GetMapping("/volleymatch/teams")
	public String getAllTeams(Model model) {	
		model.addAttribute("teams", teamService.getAllTeams());		
		return "teams";
	}
	
	@PostMapping("/volleymatch/saveTeam")		
	public String saveTeam(Team team) {
		
		teamService.saveTeam(team);
		
		return "redirect:/volleymatch/teams";
	}	
		
	@GetMapping("/volleymatch/team/{teamId}")
	@ResponseBody
	public Optional<Team> getTeam(@PathVariable Integer teamId) {
		return teamService.getTeam(teamId);
	}	
		
	@PostMapping("/volleymatch/deleteTeam/{teamId}")
	public String deleteTeam(@PathVariable Integer teamId) {
		
		Optional<Team> team = teamService.getTeam(teamId);
		if (team.isPresent()) {
			teamService.deleteTeam(team.get());
		}
		
		return "redirect:/volleymatch/teams";
	}		
}
