package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.ClubDAO;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.model.Puntuation;
import com.mcv.cdmapp.model.Race;

@Service
public class ClubServiceImp implements ClubService{

	@Autowired
	ClubDAO clubDAO;
	@Autowired
	RaceService raceService;
	@Autowired
	PuntuationService puntuationService;
	@Autowired
	ObjectToFileService objectToFileService;
	
	@Override
	public Club getOne(Integer idClub) {
		return clubDAO.getOne(idClub);
	}

	@Override
	public Club addClub(Club club) {
		return clubDAO.save(club);	
	}

	@Override
	public List<Club> findByRaceOrderByPoints(Integer idRace) throws IOException {
		Race r = raceService.get(idRace);
		
		List<Puntuation> puntuations = puntuationService.getAllOrderByPosition();
		Integer podiumSize= puntuations.size();		
	
		List<Club> clubs = clubDAO.findClubNameByMaxPoints(r,PageRequest.of(0,  podiumSize)).getContent();		
		
		String clasif = sortedMap(createClasif(puntuations, clubs));
		
		objectToFileService.saveToFile(clasif, "Clubs clasification");

		return clubDAO.findClubNameByMaxPoints(r,PageRequest.of(0,  podiumSize)).getContent();		
		
	}	
	
	/**
     * Devuelve un map ordenado por valor
     * @param collection El map que vamos a ordenar por valor
     */
	public String sortedMap(Map<String, Integer> collection){
		
		Map<String, Integer> pod = new LinkedHashMap<>();
		collection.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.forEachOrdered(c -> pod.put(c.getKey(), c.getValue()));

		
		String clasif = "";
		for (Map.Entry<String, Integer> entry : pod.entrySet()) {
		    clasif+= entry.getKey() + " " + entry.getValue() + " points.\n";		
		}
		
		return clasif;
	}
	
	/**
     * Devuelve un map con una clasificación de carrera por puntos de club
     * @param puntuations La lista que contiene las puntuaciones por puesto
     * @param clubs La lista que contiene las posiciones en la carrera por club
     */
	public Map<String, Integer> createClasif(List<Puntuation> puntuations, 
			List<Club> clubs){
		
		Map<String, Integer> podium = new HashMap();
		
		for(int i = 0;i<clubs.size();i++) {
			
			if(podium.containsKey(clubs.get(i).getName())){
				Integer points = podium.get(clubs.get(i).getName()) 
						+ puntuations.get(i).getPoints();
				podium.put(clubs.get(i).getName(), points);
			}
			else {
				podium.put(clubs.get(i).getName(), 
						puntuations.get(i).getPoints());
			}
		}	
		return podium;
	}
}
