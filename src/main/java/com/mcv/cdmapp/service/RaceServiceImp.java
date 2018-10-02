package com.mcv.cdmapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.RaceDAO;



@Service
public class RaceServiceImp implements RaceService{

	@Autowired
	private RaceDAO raceDAO;
}
