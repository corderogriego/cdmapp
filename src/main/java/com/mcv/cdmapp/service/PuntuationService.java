package com.mcv.cdmapp.service;

import java.util.List;

import com.mcv.cdmapp.model.Puntuation;

public interface PuntuationService {

	/**
     * Devuelve una lista con todas las puntuaciones
     */
	List<Puntuation> getAllOrderByPosition();
}
