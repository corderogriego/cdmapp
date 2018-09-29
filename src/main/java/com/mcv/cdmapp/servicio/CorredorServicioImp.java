package com.mcv.cdmapp.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.CorredorDAO;

@Service
public class CorredorServicioImp implements CorredorServicio{

	@Autowired
	private CorredorDAO corredorDAO;
}
