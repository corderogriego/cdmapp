package com.mcv.cdmapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mcv.cdmapp.dto.DtoRunner;
import com.mcv.cdmapp.model.Runner;

@Component
public class RunnerMapperImp implements RunnerMapper{

	
	@Override
	public DtoRunner mapToDto(Runner model) {
		DtoRunner dto = DtoRunner.builder()
				.idRunner(model.getIdRunner())
				.name(model.getName())
				.nameClub(model.getClub().getName())
				.year(model.getYear())
				.build();
		return dto;		
	}

	@Override
	public Runner dtoToMap(DtoRunner dto) {
		Runner runner = new Runner();
		
		runner.setIdRunner(dto.getIdRunner());
		runner.setName(dto.getName());
		runner.setYear(dto.getYear());
		
		return runner;
	}

	@Override
	public List<DtoRunner> listMapToDto(List<Runner> models) {
		List<DtoRunner> dtoRunners = new ArrayList<>();
		
		for(Runner r : models) {
			dtoRunners.add(DtoRunner.builder()
					.idRunner(r.getIdRunner())
					.name(r.getName())
					.nameClub(r.getClub().getName())
					.year(r.getYear())
					.build());
		}
		return dtoRunners;
	}

}
