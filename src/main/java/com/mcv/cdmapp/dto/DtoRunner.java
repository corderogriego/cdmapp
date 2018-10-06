package com.mcv.cdmapp.dto;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
@Data
@Builder
public class DtoRunner {

	private Integer idRunner;
	private String name;
	private String nameClub;
	private Integer year;
		
	
	public DtoRunner(Integer idRunner, String name, String nameClub, Integer year) {
		super();
		this.idRunner = idRunner;
		this.name = name;
		this.nameClub = nameClub;
		this.year = year;
	}



	public DtoRunner() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
