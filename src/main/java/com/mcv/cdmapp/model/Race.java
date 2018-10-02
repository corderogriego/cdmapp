package com.mcv.cdmapp.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Race {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idRace;
	
	private Date dateRace;
	private String name;
	private Integer km; 
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "race")
	private List<Result> results = new ArrayList<>();
}
