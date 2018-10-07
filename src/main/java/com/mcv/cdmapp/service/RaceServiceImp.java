package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.RaceDAO;
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
	public void getClasif(Race race) throws IOException {
			
		saveClasif(runnerService.getAllByRaceTime(race,20,29),"Master29");
		saveClasif(runnerService.getAllByRaceTime(race,30,39),"Master39");
		saveClasif(runnerService.getAllByRaceTime(race,40,65),"Master40+");
	
	}
	
	/**
     * Pasa una List a cadena de texto y la almacena en un archivo
     * @param runners list que se va a pasar a cadena de texto
     * @param master nombre para el archivo de texto que se va a almacenar
     * */
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
