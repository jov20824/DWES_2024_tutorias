package com.spring.tutoriasEDU.enmarca;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class EnmarcaKey implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long idActividad;
	private Long idPlan;
	
	
	
	public Long getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(Long idActividad) {
		this.idActividad = idActividad;
	}
	public Long getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idActividad, idPlan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnmarcaKey other = (EnmarcaKey) obj;
		return Objects.equals(idActividad, other.idActividad) && Objects.equals(idPlan, other.idPlan);
	}
	
	
}
