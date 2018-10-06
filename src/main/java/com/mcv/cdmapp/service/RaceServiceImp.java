package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.RaceDAO;
import com.mcv.cdmapp.dao.RunnerDAO;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Runner;



@Service
public class RaceServiceImp implements RaceService{

	@Autowired
	RaceDAO raceDAO;
	@Autowired
	RunnerService runnerService;
	@Autowired
	ClubService clubService;
	@Autowired
	ObjectToFileService objectToFileService;
	
	@Override
	public Race add(Race race) {
		return raceDAO.save(race);
	}

	@Override
	public Race get(Integer idRace) {
		return raceDAO.getOne(idRace);
	}

	@Override
	public List<Runner> getClasif(Race race) throws IOException {
				
		List<Runner> runners = runnerService.getAllByRaceTime(race,16,19);		
		runners.addAll(runnerService.getAllByRaceTime(race,20,29));
		runners.addAll(runnerService.getAllByRaceTime(race,30,39));
		runners.addAll(runnerService.getAllByRaceTime(race,40,65));
		
		
		saveClasif(runnerService.getAllByRaceTime(race,16,19),"Master19");
		saveClasif(runnerService.getAllByRaceTime(race,20,29),"Master29");
		saveClasif(runnerService.getAllByRaceTime(race,30,39),"Master39");
		saveClasif(runnerService.getAllByRaceTime(race,40,65),"Master40+");
		
		return runners;
		
	}
	
	public void saveClasif(List<Runner> runners, String master) throws IOException {
		
		String clasif = master+"\n";
		Integer position = 1;
		
		for(Runner r : runners) {
			clasif+="Position "+position + ": "+ r.toString()+"\n";
			position++;			
		}
		
		objectToFileService.saveToFile(clasif, master);		
	}

	@Override
	public List<Club> getClasifByClub(Integer idRace) throws IOException {
		return clubService.findByRaceOrderByPoints(idRace);
		
	}
	
}
