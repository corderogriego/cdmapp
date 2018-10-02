package com.mcv.cdmapp.dto;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

//@Builder
@Data
@Component
public class DtoClub {

	private Integer idClub; 
	private String name;
	
	public DtoClub() {}
	
	public DtoClub(Integer idClub, String nombre) {
		super();
		this.idClub = idClub;
		this.name = nombre;
	}

	public Integer getIdClub() {
		return idClub;
	}
	public void setIdClub(Integer idClub) {
		this.idClub = idClub;
	}
	public String getName() {
		return name;
	}
	public void setName(String nombre) {
		this.name = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DtoClub other = (DtoClub) obj;
		if (idClub == null) {
			if (other.idClub != null)
				return false;
		} else if (!idClub.equals(other.idClub))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idClub == null) ? 0 : idClub.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		return "DtoClub [idClub=" + idClub + ", nombre=" + name + "]";
	}
		
}
