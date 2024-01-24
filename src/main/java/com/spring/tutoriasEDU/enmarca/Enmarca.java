package com.spring.tutoriasEDU.enmarca;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.start.juega.JuegaKey;
import com.spring.start.plataforma.Plataforma;
import com.spring.start.videojuego.Videojuego;
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
	@JoinColumn(name="actividades_id")
	@JsonBackReference
	private Actividad actividad;
	
	@ManyToOne
	@MapsId("idPlan")
	@JoinColumn(name="plan_id")
	@JsonBackReference
	private Plan plan;
	
	private fecha;
}
