package com.mcv.cdmapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.ClubDAO;
import com.mcv.cdmapp.model.Club;

@Service
public class ClubServiceImp implements ClubService{

	@Autowired
	private ClubDAO clubDAO;

	@Override
	public String clubMaxPoints() {
		return clubDAO.findClubNameByMaxPoints().toString();
	}

	@Override
	public Club clubById(Integer idClub) {
		return clubDAO.getOne(idClub);
	}

	@Override
	public List<Club> clubAll() {		
		return clubDAO.findAll();
	}

	@Override
	public void deleteClub(Integer idClub) {
		clubDAO.deleteById(idClub);		
	}

	@Override
	public Optional<Club> addClub(Club club) {
		clubDAO.save(club);
		
		return clubDAO.findById(club.getIdClub());
	}

	
}
