package com.mcv.cdmapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.mcv.cdmapp.dao.RunnerDAO;
import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Runner;



@Service
public class RunnerServiceImp implements RunnerService{

	@Autowired
	RunnerDAO runnerDAO;

	@Autowired
	ClubService clubService;
	
	@Override
	public void delete(Integer idRunner) {
		runnerDAO.deleteById(idRunner);		
	}

	@Override
	public Runner getOne(Integer idRunner) {
		return runnerDAO.getOne(idRunner);
	}

	@Override
	public List<Runner> getAll(PageRequest pageRequest) {
		return runnerDAO.findAll(pageRequest).getContent();
	}

	@Override
	public Runner addOne(Runner runner, Integer idClub) {		
		runner.setClub(clubService.getOne(idClub));
		return runnerDAO.save(runner);
	}

//	@Override
//	public Runner addOne(Runner runner) {
//		return runnerDAO.save(runner);
//	}
	
	@Override
	public void update(Runner runner) {
		runnerDAO.save(runner);
	}

	@Override
	public void update(Runner runner, Integer idClub) {
		runner.setClub(clubService.getOne(idClub));
		runnerDAO.save(runner);
		
	}

	@Override
	public List<Runner> getAllByRaceTime(Race race, Integer minAge, Integer maxAge) {
		return runnerDAO.findRunnerOrderByRacePosition(race,minAge,maxAge);
	}

	
}
