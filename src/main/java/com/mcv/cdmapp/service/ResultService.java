package com.mcv.cdmapp.service;

import java.util.List;

import com.mcv.cdmapp.model.Result;

public interface ResultService {

	Result add(Result result, Integer idRace, Integer idRunner);

	Result getOne(Integer idResult);

	List<Result> findAll();

}
