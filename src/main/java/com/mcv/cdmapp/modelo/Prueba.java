package com.mcv.cdmapp.modelo;


import java.util.ArrayList;
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
public class Prueba {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPrueba;
	
	private String nombre;
	private Integer km; 
		
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prueba")
	private List<Resultado> resultados = new ArrayList<>();
}
