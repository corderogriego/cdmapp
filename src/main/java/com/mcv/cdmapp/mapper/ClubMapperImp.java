package com.mcv.cdmapp.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcv.cdmapp.dto.DtoClub;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.service.ClubServiceImp;

@Component
public class ClubMapperImp implements ClubMapper{

	@Autowired
	ClubServiceImp clubServiceImp;
	
	@Autowired
	DtoClub dtoClub;
	
	@Override
	public DtoClub mapToDto(Club club) {
		
		Club c = clubServiceImp.getOne(club.getIdClub());
		
		dtoClub.setIdClub(c.getIdClub());
		dtoClub.setName(c.getName());
		
		return dtoClub;
	}

	@Override
	public Club dtoToMap(DtoClub dtoClub) {
		
		Club c = new Club();		
		c.setIdClub(dtoClub.getIdClub());
		c.setName(dtoClub.getName());
		
		return c;
	}

	@Override
	public List<DtoClub> listMapToDto(List<Club> clubs) {

		List<DtoClub> dtoclubs = new ArrayList<>();
		
		for(Club c: clubs) {
			dtoclubs.add(new DtoClub(c.getIdClub(),c.getName()));			
		}
		return dtoclubs;
	}

	
}
