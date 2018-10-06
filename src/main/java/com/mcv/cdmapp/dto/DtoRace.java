package com.mcv.cdmapp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DtoRace {

	private Integer idRace;
	private String name;
	private String date;
}
