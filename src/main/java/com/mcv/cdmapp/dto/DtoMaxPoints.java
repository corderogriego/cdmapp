package com.mcv.cdmapp.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class DtoMaxPoints {

	private String name;
	private long points;
	
	public DtoMaxPoints() {}
	public DtoMaxPoints(String name, long points) {
		super();
		this.name = name;
		this.points = points;
	}
	@Override
	public String toString() {
		return name + " - " + points;
	}
	
	
}
