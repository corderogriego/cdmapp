package com.mcv.cdmapp.modelo;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Resultado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idResultado;
	private HashMap<Integer, Corredor> posiciones;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Prueba prueba;
}
