package com.mcv.cdmapp.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Corredor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCorredor;
	private String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Club club;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "corredor")
	private List<Prueba> pruebas = new ArrayList<>();
}
