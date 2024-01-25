package com.spring.tutoriasEDU.planes;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.spring.tutoriasEDU.Curso.Curso;
import com.spring.tutoriasEDU.enmarca.Enmarca;
import com.spring.tutoriasEDU.tutores.Tutor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;



@Entity
public class Plan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	
	@OneToOne(targetEntity=Tutor.class,mappedBy="plan")
	private Tutor tutor;

	
	@ManyToOne
	@JoinColumn(name="FK_CURSO")
	private Curso curso;
	
	@OneToMany(mappedBy = "plan")
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
    private Set<Enmarca> enmarcar = new HashSet<>();
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	@Override
	public String toString() {
		return "Plan [id=" + id + ", nombre=" + nombre + ", tutor=" + tutor + ", curso=" + curso + "]";
	}

	public Set<Enmarca> getEnmarcar() {
		return enmarcar;
	}

	public void setEnmarcar(Set<Enmarca> enmarcar) {
		this.enmarcar = enmarcar;
	}
	
	
	
	
	
	
}
