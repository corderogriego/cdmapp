package com.mcv.cdmapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcv.cdmapp.dao.ResultDAO;

@Service
public class ResultServiceImp implements ResultService{

	@Autowired
	private ResultDAO resultDAO;
}
