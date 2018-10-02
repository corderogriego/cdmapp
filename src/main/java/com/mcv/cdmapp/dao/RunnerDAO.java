package com.mcv.cdmapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mcv.cdmapp.model.Runner;

public interface RunnerDAO extends JpaRepository<Runner, Integer> {

	//JPQL
	@Query("select c.name, sum(r.points) "
			+ "from Runner c join c.results r "
			+ "order by r.points ")
	List<String> findRunnerNameOrderByPoints();
		
}
