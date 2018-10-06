package com.mcv.cdmapp.controller;

import java.util.List;

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

import com.mcv.cdmapp.dto.DtoRunner;
import com.mcv.cdmapp.mapper.RunnerMapper;
import com.mcv.cdmapp.model.Runner;
import com.mcv.cdmapp.service.RunnerService;

@RestController
@RequestMapping("/runner")
public class RunnerController {

	@Autowired
	RunnerMapper runnerMapper;
	
	@Autowired
	RunnerService runnerService;
	
	@GetMapping("/{idRunner}")
	public DtoRunner get(@PathVariable Integer idRunner) {
		return runnerMapper.mapToDto(runnerService.getOne(idRunner));
	}
	
	@GetMapping
	public List<DtoRunner> getAll(@RequestParam(defaultValue = "0", value = "page", required = false) Integer page,
			@RequestParam(defaultValue = "5", value = "size", required = false) Integer size){
		return runnerMapper.listMapToDto(runnerService.getAll((PageRequest.of(page, size))));		
	}
	
	@PostMapping("/{idClub}")
	public DtoRunner add(@RequestBody DtoRunner dtoRunner, @PathVariable Integer idClub) {
		return runnerMapper.mapToDto(runnerService.addOne(runnerMapper.dtoToMap(dtoRunner),idClub));
	}
	
	@PostMapping
	public DtoRunner add(@RequestBody DtoRunner dtoRunner) {
		return runnerMapper.mapToDto(runnerService.addOne(runnerMapper.dtoToMap(dtoRunner)));
	}
	
	@PutMapping("/{idRunner}")
	public void update(@RequestBody DtoRunner dtoRunner, @PathVariable Integer idRunner) {
		//dtoRunner.setIdRunner(idRunner);
		Runner runner = runnerMapper.dtoToMap(dtoRunner);
		//System.out.println(runner.getIdRunner());
		//runner.setIdRunner(idRunner);
		runnerService.update(runner);
	}
	
//	@PutMapping("/{idRunner}/{idClub}")
//	public void update(@RequestBody DtoRunner dtoRunner, @PathVariable Integer idRunner, 
//			@PathVariable Integer idClub) {
//		Runner runner = runnerMapper.dtoToMap(dtoRunner);
//				
//		runnerService.update(runner, idClub);
//	}
	
	@DeleteMapping("/{idRunner}")
	public void delete(@PathVariable Integer idRunner) {
		runnerService.delete(idRunner);
	}
	
}
