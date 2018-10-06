package com.mcv.cdmapp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Runner;

public interface RunnerService {

	void delete(Integer idRunner);

	Runner getOne(Integer idRunner);

	List<Runner> getAll(PageRequest pageRequest);

	Runner addOne(Runner runner, Integer idClub);
	
	Runner addOne(Runner runner);

	void update(Runner runner);
	
	void update(Runner runner, Integer idClub);
	
	List<Runner> getAllByRaceTime(Race race, Integer minAge, Integer maxAge);	
	

}
