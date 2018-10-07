package com.mcv.cdmapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcv.cdmapp.dto.DtoClub;
import com.mcv.cdmapp.mapper.ClubMapper;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.service.ClubService;

@RestController
@RequestMapping("/club")
public class ClubController{

	@Autowired
	ClubService clubService;	
	@Autowired
	ClubMapper clubMapper;	

	@GetMapping("/{idClub}")
	public DtoClub getClub(@PathVariable Integer idClub) {
		return clubMapper.mapToDto(clubService.getOne(idClub));
	}
	
	@PostMapping
	public DtoClub addClub(@RequestBody DtoClub dtoClub) {			
		
		Club club = clubMapper.dtoToMap(dtoClub);
		Club clubCreated = clubService.addClub(club);

		return clubMapper.mapToDto(clubCreated);		
	}

}
