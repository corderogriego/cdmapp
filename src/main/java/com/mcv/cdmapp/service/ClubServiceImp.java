package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.text.Position;

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
	PuntuationService puntuationService;
	@Autowired
	ObjectToFileService objectToFileService;
	
//	@Override
//	public String clubMaxPoints() {
//		return clubDAO.findClubNameByMaxPoints().toString();	
//	}

	@Override
	public Club getOne(Integer idClub) {
		return clubDAO.getOne(idClub);
	}

	@Override
	public void deleteClub(Integer idClub) {
		clubDAO.deleteById(idClub);		
	}

	@Override
	public Club addClub(Club club) {
			
//		clubDAO.findById(club.getIdClub());
		return clubDAO.save(club);	
	}

	@Override
	public void update(Club club) {
		
		clubDAO.saveAndFlush(club);
		
	}

	@Override
	public List<Club> findAll(Pageable pageable, String name) {
		
			return clubDAO.findByNameContaining(name, pageable).getContent();
		
	}

	@Override
	public String clubMaxPoints() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Club> findByRaceOrderByPoints(Integer idRace) throws IOException {
		
		List<Puntuation> puntuations = puntuationService.getAllOrderByPosition();
		Integer podiumSize= puntuations.size();
		
		List<Club> clubs = clubDAO.findClubNameByMaxPoints(idRace, podiumSize);
		
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
		
		Map<String, Integer> pod = new LinkedHashMap<>();
		podium.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				.forEachOrdered(c -> pod.put(c.getKey(), c.getValue()));

		
		String clasif = "";
		for (Map.Entry<String, Integer> entry : pod.entrySet()) {
		    clasif+= entry.getKey() + " " + entry.getValue() + " points.\n";		
		}
		
		objectToFileService.saveToFile(clasif, "Clubs clasification");
		
		return clubDAO.findClubNameByMaxPoints(idRace, podiumSize);
	}	
}
