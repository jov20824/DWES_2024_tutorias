package com.spring.tutoriasEDU.enmarca;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.tutoriasEDU.actividades.Actividad;
import com.spring.tutoriasEDU.planes.Plan;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Enmarca {
	
	@EmbeddedId private EnmarcaKey id;
	
	@ManyToOne
	@MapsId("idActividad")
	@JoinColumn(name="actividad_id")
	@JsonBackReference
	private Actividad actividad;
	
	@ManyToOne
	@MapsId("idPlan")
	@JoinColumn(name="plan_id")
	@JsonBackReference
	private Plan plan;
	
	private String fecha;

	public EnmarcaKey getId() {
		return id;
	}

	public void setId(EnmarcaKey id) {
		this.id = id;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
