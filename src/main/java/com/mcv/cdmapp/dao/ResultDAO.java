package com.mcv.cdmapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mcv.cdmapp.model.Result;

@Repository
public interface ResultDAO extends JpaRepository<Result, Integer>{

}
