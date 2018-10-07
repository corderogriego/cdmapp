package com.mcv.cdmapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.PuntuationDAO;
import com.mcv.cdmapp.model.Puntuation;

@Service
public class PuntuationServiceImp implements PuntuationService{
	
	@Autowired
	PuntuationDAO puntuationDAO;
	
	public List<Puntuation> getAllOrderByPosition(){
		return puntuationDAO.findAll();
	}
}
