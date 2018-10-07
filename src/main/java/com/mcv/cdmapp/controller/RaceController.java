package com.mcv.cdmapp.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcv.cdmapp.dto.DtoRace;
import com.mcv.cdmapp.dto.DtoRunner;
import com.mcv.cdmapp.mapper.RaceMapper;
import com.mcv.cdmapp.mapper.RunnerMapper;
import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.service.RaceService;

@RestController
@RequestMapping("/race")
public class RaceController {

	@Autowired
	RaceMapper raceMapper;
	@Autowired
	RunnerMapper runnerMapper;	
	@Autowired
	RaceService raceService;
	
	@GetMapping("/{idRace}")
	public void getClasif(@PathVariable Integer idRace) throws IOException{
		Race r = raceService.get(idRace);
		raceService.getClasif(r);
	}
	
	@GetMapping("/{idRace}/club")
	public void getClasifByClub(@PathVariable Integer idRace) throws IOException{
		raceService.getClasifByClub(idRace);		
	}
	
	@PostMapping
	public DtoRace add(@RequestBody DtoRace dtoRace) {
		Race race = raceMapper.dtoToMap(dtoRace);
		return raceMapper.mapToDto(raceService.add(race));		
	}
}
