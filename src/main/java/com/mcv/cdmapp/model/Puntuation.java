package com.mcv.cdmapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Puntuation {

	@Id
	private Integer position;
	private Integer points;
}
