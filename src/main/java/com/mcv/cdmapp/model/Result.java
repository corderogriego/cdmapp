package com.mcv.cdmapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
//@IdClass(PkResult.class)
//@Table(indexes = { 
//		@Index(name = "pkResult", columnList = "idRunner, idRace", unique = true) })
@Getter @Setter
public class Result implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PkResult pkResult;
	
	private Integer position;
	private Integer points;
	
	@MapsId("id_runner")
//	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRunner")
//	@Column(name = "idRunner")
	private Runner runner;
	
//	@Id
	@MapsId("id_race")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRace")
//	@Column(name = "idRace")
	private Race race;
	
	
}