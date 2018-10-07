package com.mcv.cdmapp.service;

import java.io.IOException;
import java.util.List;

import com.mcv.cdmapp.model.Club;
import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Runner;

public interface RaceService {

	/**
     * Añade una carrera
     * @param race carrera que vamos a añadir*/
	public Race add(Race race);

	/**
     * Devuelve una carrera
     * @param idRace identificador de la carrera que vamos a buscar
     * */
	public Race get(Integer idRace);
	
	/**
     * Almacena la clasificación de una carrera por categorias en archivos
     * @param race carrera de la que vamos a devolver la clasificación
     * */
	public void getClasif(Race race) throws IOException;
	
	/**
     * Almacena la clasificación de una carrera por clubes
     * @param idRace identificador de la carrera de la que vamos a devolver la clasificación
     * */
	public List<Club> getClasifByClub(Integer idRace) throws IOException;
}
