package com.mcv.cdmapp.modelo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Entity
//@IdClass(PkResultado.class)
@Getter @Setter
public class Resultado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PkResultado pkResultado;
	
	private Integer posicion;
	private Integer puntos;
	
	@MapsId("id_corredor")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCorredor")
	private Corredor corredor;
	
	@MapsId("id_prueba")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPrueba")
	private Prueba prueba;
	
	
}