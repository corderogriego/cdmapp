package com.mcv.cdmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mcv.cdmapp.dto.DtoClub;
import com.mcv.cdmapp.mapper.ClubMapperImp;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.service.ClubService;


@RestController
@RequestMapping("/club")
public class ClubController{

	@Autowired
	ClubService clubService;
	
	@Autowired
	ClubMapperImp clubMapper;
	
	@GetMapping("/max")
	String getClubMaxPoints() {
		return clubService.clubMaxPoints();
	}
	
	//Club por id
	@GetMapping("/{idClub}")
	DtoClub getClub(@PathVariable Integer idClub) {
		return clubMapper.mapToDto(clubService.clubById(idClub));
	}
	
	//Lista de clubes
	@GetMapping
	List<DtoClub> getAllClub(
			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "5", value = "size", required = false) Integer size,
			@RequestParam(value = "name", required = false) String name){
		return clubMapper.listMapToDto(clubService.clubAll());
	}
	
	//Añade un club
	@PostMapping
	DtoClub addClub(@RequestBody DtoClub dtoClub) {			
		
		//clubMapper.dtoToMap(dtoClub)
		return dtoClub;		
	}
	
	//Actualiza un club
	@PutMapping("/{idClub}")
	DtoClub updateClub(@RequestBody DtoClub dtoClub, @PathVariable Integer idClub) {
		
		return dtoClub;
	}
	
	//Borra club por id
	@DeleteMapping("/{idClub}")
	void deleteClub(@PathVariable Integer idClub) {
		clubService.deleteClub(idClub);
	}

}
