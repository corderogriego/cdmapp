package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.mcv.cdmapp.dto.DtoMaxPoints;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.model.Race;

public interface ClubService {

	String clubMaxPoints();

	List<Club> findAll(Pageable pageable, String name);
	
	void deleteClub(Integer idClub);
	
	Club addClub(Club club);
	
	void update(Club club);

	Club getOne(Integer idClub);
	
	List<Club> findByRaceOrderByPoints(Integer idRace) throws IOException;
	
}
