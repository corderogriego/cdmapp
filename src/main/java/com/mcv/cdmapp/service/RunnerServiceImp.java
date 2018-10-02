package com.mcv.cdmapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.RunnerDAO;



@Service
public class RunnerServiceImp implements RunnerService{

	@Autowired
	private RunnerDAO runnerDAO;
}
