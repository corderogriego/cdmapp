package com.mcv.cdmapp.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mcv.cdmapp.dto.DtoRace;
import com.mcv.cdmapp.model.Race;

@Component
public class RaceMapperImp implements RaceMapper{

	@Override
	public DtoRace mapToDto(Race model) {
		
		DtoRace dtoRace = new DtoRace();
		dtoRace.setIdRace(model.getIdRace());
		dtoRace.setName(model.getName());
		dtoRace.setDate(model.getDate());
		
		return dtoRace;
	}

	@Override
	public Race dtoToMap(DtoRace dto) {
		
		Race race = new Race();
		race.setIdRace(dto.getIdRace());
		race.setName(dto.getName());
		race.setDate(dto.getDate());
		
		return race;
	}

	@Override
	public List<DtoRace> listMapToDto(List<Race> models) {
		// TODO Auto-generated method stub
		return null;
	}

}
