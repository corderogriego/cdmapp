package com.mcv.cdmapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Runner;

@Repository
public interface RunnerDAO extends JpaRepository<Runner, Integer> {
//
//	//JPQL
//	@Query("select c.name, sum(r.points) "
//			+ "from Runner c join c.results r "
//			+ "order by r.points ")
//	List<String> findRunnerNameOrderByPoints();
	
	//JPQL
	@Query("select r from Runner r join r.results re "
			+ "where re.race = ?1 and r.year < year(current_timestamp) - ?2 "
			+ "and r.year > year(current_timestamp) - ?3 "
			+ "order by re.seconds asc")
	List<Runner> findRunnerOrderByRacePosition(Race race, Integer minAge, Integer maxAge);
	
	
}
