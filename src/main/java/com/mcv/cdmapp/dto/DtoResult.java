package com.mcv.cdmapp.dto;

import org.springframework.stereotype.Component;

import com.mcv.cdmapp.model.Runner;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Component
public class DtoResult {

	private Integer idResult;
	private String nameRunner;	
	private Integer seconds;
	
	
	public DtoResult() {
		
	}
	public DtoResult(Integer idResult, String nameRunner, Integer seconds) {
		super();
		this.idResult = idResult;
		this.nameRunner = nameRunner;
		this.seconds = seconds;
	}
	
	public String getNameRunner() {
		return nameRunner;
	}
	public void setNameRunner(String nameRunner) {
		this.nameRunner = nameRunner;
	}
	public Integer getIdResult() {
		return idResult;
	}
	public void setIdResult(Integer idResult) {
		this.idResult = idResult;
	}
	
	public Integer getSeconds() {
		return seconds;
	}
	public void setSeconds(Integer seconds) {
		this.seconds = seconds;
	}
	
	
	
}
