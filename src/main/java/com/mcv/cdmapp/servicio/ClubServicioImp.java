package com.mcv.cdmapp.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.ClubDAO;

@Service
public class ClubServicioImp implements ClubServicio{

	@Autowired
	private ClubDAO clubDAO;
	
}
