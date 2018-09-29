package com.mcv.cdmapp.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Prueba {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPrueba;
	private String nombre;
	private Integer km; 
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "prueba")
	private List<Corredor> corredores = new ArrayList<>();
	
	@OneToOne(fetch = FetchType.LAZY)
	private Resultado resultado;
}
