package com.mcv.cdmapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class PkResult implements Serializable {

	private Integer idCorredor;
	
	private Integer idPrueba;
    
    public PkResult() {}
    
	public PkResult(int idCorredor, int idPrueba) {
		super();
		this.idCorredor = idCorredor;
		this.idPrueba = idPrueba;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCorredor == null) ? 0 : idCorredor.hashCode());
		result = prime * result + ((idPrueba == null) ? 0 : idPrueba.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PkResult other = (PkResult) obj;
		if (idCorredor == null) {
			if (other.idCorredor != null)
				return false;
		} else if (!idCorredor.equals(other.idCorredor))
			return false;
		if (idPrueba == null) {
			if (other.idPrueba != null)
				return false;
		} else if (!idPrueba.equals(other.idPrueba))
			return false;
		return true;
	}      
    
}
