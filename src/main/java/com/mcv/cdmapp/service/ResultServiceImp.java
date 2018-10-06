package com.mcv.cdmapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.ResultDAO;
import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Result;
import com.mcv.cdmapp.model.Runner;

@Service
public class ResultServiceImp implements ResultService{

	@Autowired
	private ResultDAO resultDAO;
	@Autowired
	RaceService raceService;
	@Autowired
	RunnerService runnerService;

	@Override
	public Result add(Result result, Integer idRace, Integer idRunner) {
		result.setRace(getRace(idRace));
		result.setRunner(getRunner(idRunner));
		return resultDAO.save(result);
	}
	
	public Race getRace(Integer idRace) {
		return raceService.get(idRace);
	}

	public Runner getRunner(Integer idRunner) {
		return runnerService.getOne(idRunner);
	}
	@Override
	public Result getOne(Integer idResult) {
		return resultDAO.getOne(idResult);
	}

	@Override
	public List<Result> findAll() {
		return resultDAO.findAll();
	}
}
