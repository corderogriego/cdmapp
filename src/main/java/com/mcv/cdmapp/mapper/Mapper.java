package com.mcv.cdmapp.mapper;

import java.util.List;

import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.service.ClubServiceImp;

import lombok.Data;

public interface Mapper <M, DTO> {

	DTO mapToDto(M model) ;
	M dtoToMap(DTO dto);
	
	List<DTO> listMapToDto(List<M> models);
	
}
