package com.mcv.cdmapp.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Runner;

public interface RunnerService {

	/**
     * Elimina un corredor
     * @param idRunner identificador del corredor que vamos a eliminar
     * */
	void delete(Integer idRunner);

	/**
     * Obtinene un corredor
     * @param irRunner identificador del corredor que vamos a buscar
     * */
	Runner getOne(Integer idRunner);

	/**
     * Obtiene una list con todos los corredores
     * @param pageRequest establece el número de página y los registros por cada consulta
     * */
	List<Runner> getAll(PageRequest pageRequest);

	/**
     * Añade un corredor
     * @param runner rcorredor que vamos a añadir
     * @param idClub identificador del club al que pertenece
     * */
	Runner addOne(Runner runner, Integer idClub);
	
//	Runner addOne(Runner runner);

	/**
     * Actualiza un corredor
     * @param runner corredor que vamos a actualizar
     * */
	void update(Runner runner);

	/**
     * Actualiza un carredor y su club
     * @param runner corredor que se va a actualizar
     * @param idClub identificador del club al que se va a asignar el corredor
     * */
	void update(Runner runner, Integer idClub);

	/**
     * Obtiene un lista de corredores de una carrera ordenados por categoria
     * @param race carrera de la que obtendremos los corredores
     * @param minAge edad mínima de la categoría
     * @param maxAge edad máxima de la categoría
     * */
	List<Runner> getAllByRaceTime(Race race, Integer minAge, Integer maxAge);	
	

}
