package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Pageable;

import com.mcv.cdmapp.model.Club;

public interface ClubService {

	/**
     * Añade un club
     * @param club el club que vamos a añadir
     */
	Club addClub(Club club);
	

	/**
     * Obtiene un club de la base de datos
     * @param idClub La id del club que vamos a buscar
     */
	Club getOne(Integer idClub);
	
	/**
     * Obtiene una lista de club de cada participante en una carrera
     * @param idRace El id de la carrera de la que vamos a obtener la lista de club
     */
	List<Club> findByRaceOrderByPoints(Integer idRace) throws IOException;
	
}
