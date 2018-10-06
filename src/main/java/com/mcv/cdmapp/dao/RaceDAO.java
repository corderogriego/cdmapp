package com.mcv.cdmapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcv.cdmapp.model.Race;

@Repository
public interface RaceDAO extends JpaRepository<Race, Integer>{

}
