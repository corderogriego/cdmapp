package com.mcv.cdmapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(indexes = { 
		@Index(name = "pkResult", columnList = "id_runner, id_race", unique = true) })
@Getter @Setter
public class Result implements Serializable{

	private static final long serialVersionUID = 1L;
//	
//	@EmbeddedId
//	private PkResult pkResult;
//	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_result")
	private Integer idResult;
	
	private Integer seconds;
	
//	@MapsId("id_runner")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_runner")
//	@Column(name = "idRunner")
	private Runner runner;
	
//	@MapsId("id_race")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_race")
//	@Column(name = "idRace")
	private Race race;
	
	
}