package com.diaspora.TournamentPlanner.Tournament;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentDao extends CrudRepository<Tournament, Integer> {
 
}
