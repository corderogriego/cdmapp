package com.mcv.cdmapp.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.ResultadoDAO;

@Service
public class ResultadoServicioImp implements ResultadoServicio{

	@Autowired
	private ResultadoDAO resultadoDAO;
}
