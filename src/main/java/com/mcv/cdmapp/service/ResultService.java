package com.mcv.cdmapp.service;

import java.util.List;

import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Result;

public interface ResultService {

	/**
     * Añade un resultado
     * @param result resultado que se va a añadir
     * @param idRace identificador de la carrera a la que pertenece el resultado
     * @param idRunner identificador del corredor al que pertenece el resultado
     * */
	Result add(Result result, Integer idRace, Integer idRunner);

	/**
     * Obtienen un resultado
     * @param idResult identificador del resultado que queremos obtener
     * */
	Result getOne(Integer idResult);

	/**
     * Obtiene todos los resultados
     * */
	List<Result> findAll();
	
	/**
     * Obtiene todos los resultados de una carrera
     * */
	List<Result> findByRace(Integer idRace);

}
