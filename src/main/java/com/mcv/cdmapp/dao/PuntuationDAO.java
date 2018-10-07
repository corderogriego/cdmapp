package com.mcv.cdmapp.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcv.cdmapp.model.Puntuation;

@Repository
public interface PuntuationDAO extends JpaRepository<Puntuation,Integer>{

}
