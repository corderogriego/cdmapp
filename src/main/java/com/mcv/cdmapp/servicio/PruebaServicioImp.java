package com.mcv.cdmapp.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.PruebaDAO;

@Service
public class PruebaServicioImp implements PruebaServicio{

	@Autowired
	private PruebaDAO pruebaDAO;
}
