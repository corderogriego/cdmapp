package com.mcv.cdmapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcv.cdmapp.dto.DtoResult;
import com.mcv.cdmapp.mapper.ResultMapper;
import com.mcv.cdmapp.model.Result;
import com.mcv.cdmapp.service.ResultService;

@RestController
@RequestMapping("/result")
public class ResultController {

	@Autowired
	ResultMapper resultMapper;
	@Autowired
	ResultService resultService;
	
//	@GetMapping("/{idResult}")
//	public DtoResult get(@PathVariable Integer idResult) {
//		return resultMapper.mapToDto(resultService.getOne(idResult));
//	}
	
	@GetMapping("/{idRace}")
	public List<DtoResult> getAll(@PathVariable Integer idRace){		
		return resultMapper.listMapToDto(resultService.findByRace(idRace));
	}
	
	@PostMapping("/{idRace}/{idRunner}")
	public DtoResult add(@RequestBody DtoResult dtoResult, 
			@PathVariable Integer idRace, 
			@PathVariable Integer idRunner) {
		
		Result result = resultMapper.dtoToMap(dtoResult);		
		DtoResult dto = resultMapper.mapToDto(resultService.add(result,idRace,idRunner));
		
		return dto;
	}
}
