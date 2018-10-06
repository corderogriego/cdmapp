package com.mcv.cdmapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mcv.cdmapp.model.Puntuation;
import com.mcv.cdmapp.model.Race;

@Repository
public interface PuntuationDAO extends JpaRepository<Puntuation,Integer>{

	//List<Puntuation> findAllByOrderByPositionAsc();
}
