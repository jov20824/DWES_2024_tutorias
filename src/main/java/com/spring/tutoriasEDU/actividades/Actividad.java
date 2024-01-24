package com.spring.tutoriasEDU.actividades;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.tutoriasEDU.enmarca.Enmarca;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Actividad {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private boolean obligatoria;
	
	private String nombre;
	
	private String descripcion;
	
	@OneToMany(mappedBy="actividad")
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private Set<Enmarca> enmarcar = new HashSet<Enmarca>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isObligatoria() {
		return obligatoria;
	}

	public void setObligatoria(boolean obligatoria) {
		this.obligatoria = obligatoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Enmarca> getEnmarcar() {
		return enmarcar;
	}

	public void setEnmarcar(Set<Enmarca> enmarcar) {
		this.enmarcar = enmarcar;
	}
	
	
}
