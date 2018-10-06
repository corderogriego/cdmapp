package com.mcv.cdmapp.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mcv.cdmapp.dto.DtoResult;
import com.mcv.cdmapp.model.Result;

@Component
public class ResultMapperImp implements ResultMapper{

	@Override
	public DtoResult mapToDto(Result model) {
		
		DtoResult dto = new DtoResult();
		
		dto.setIdResult(model.getIdResult());
		dto.setNameRunner(model.getRunner().getName());
		dto.setSeconds(model.getSeconds());
		
		return dto;
	}

	@Override
	public Result dtoToMap(DtoResult dto) {
		
		Result result = new Result();
		
		result.setIdResult(dto.getIdResult());
		result.setSeconds(dto.getSeconds());
		
		return result;
	}

	@Override
	public List<DtoResult> listMapToDto(List<Result> models) {
		List<DtoResult> dtoResult = new ArrayList<>();
		
		for(Result r: models) {
			dtoResult.add(new DtoResult(r.getIdResult(),
					r.getRunner().getName(), 
					r.getSeconds()));			
		}
		return dtoResult;
	}

	
}
