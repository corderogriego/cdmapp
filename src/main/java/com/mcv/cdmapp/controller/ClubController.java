package com.mcv.cdmapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mcv.cdmapp.dto.DtoClub;
import com.mcv.cdmapp.mapper.ClubMapper;
import com.mcv.cdmapp.mapper.ClubMapperImp;
import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.service.ClubService;
import com.mcv.cdmapp.service.ObjectToFileService;


@RestController
@RequestMapping("/club")
public class ClubController{

	@Autowired
	ClubService clubService;
	
	@Autowired
	ClubMapper clubMapper;
	
	@Autowired
	ObjectToFileService objectToFileService;
	
//	@GetMapping("/max")
//	public String getClubMaxPoints() throws IOException {
//		String result = clubService.clubMaxPoints();
//		objectToFileService.saveToFile(result);
//		return result;
//	}
//	
	//Club por id
	@GetMapping("/{idClub}")
	public DtoClub getClub(@PathVariable Integer idClub) {
		return clubMapper.mapToDto(clubService.getOne(idClub));
	}
	
//	//Lista de clubes con filtro y paginación
//	@GetMapping
//	public List<DtoClub> getAllClub(
//			@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
//			@RequestParam(defaultValue = "5", value = "size", required = false) Integer size,
//			@RequestParam(defaultValue = "", value = "name", required = false) String name){
//		
//		List<Club> clubs = clubService.findAll((PageRequest.of(page, size)), name);
//		return clubMapper.listMapToDto(clubs);
//	}
//	
	//Añade un club
	@PostMapping
	public DtoClub addClub(@RequestBody DtoClub dtoClub) {			
		
		Club club = clubMapper.dtoToMap(dtoClub);
		Club clubCreated = clubService.addClub(club);
//		Club c = new Club();
//		c.setIdClub(9);
//		c.setName("prueba");
		return clubMapper.mapToDto(clubCreated);		
	}
	
//	//Actualiza un club
//	@PutMapping("/{idClub}")
//	public void updateClub(@RequestBody DtoClub dtoClub, @PathVariable Integer idClub) {
//		
//		Club club = clubMapper.dtoToMap(dtoClub);		
//		club.setIdClub(idClub);
//		
//		clubService.update(club);
//	}
//	
//	//Borra club por id
//	@DeleteMapping("/{idClub}")
//	public void deleteClub(@PathVariable Integer idClub) {
//		
//		clubService.deleteClub(idClub);
//	}

}
