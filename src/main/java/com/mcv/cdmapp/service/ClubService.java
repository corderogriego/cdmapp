package com.mcv.cdmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.mcv.cdmapp.model.Club;

public interface ClubService {

	String clubMaxPoints();

	Club clubById(Integer idClub);
	
	List<Club> clubAll();
	
	void deleteClub(Integer idClub);
	
	Optional<Club> addClub(Club club);
	
}
