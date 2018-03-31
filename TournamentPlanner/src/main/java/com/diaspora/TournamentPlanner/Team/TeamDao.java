package com.diaspora.TournamentPlanner.Team;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDao extends CrudRepository<Team, Integer> {
 
}
