package com.mcv.cdmapp.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcv.cdmapp.model.Race;
import com.mcv.cdmapp.model.Result;

@Repository
public interface ResultDAO extends JpaRepository<Result, Integer>{
	/**
     * Obtiene la clasificación de una carrera
     * */
	List<Result> findByRaceOrderBySeconds(Race race);
}
