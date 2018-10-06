package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Runner;

public interface RaceService {

	public Race add(Race race);

	public Race get(Integer idRace);
	
	public List<Runner> getClasif(Race race) throws IOException;
	
	public List<Club> getClasifByClub(Integer idRace) throws IOException;
}
