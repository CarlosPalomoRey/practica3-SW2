package com.sw2p3.recetario;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


@Entity
public class Receta {
	@Id
    @GeneratedValue
    private long id;
	
	@Column
	private String dificultad;
	
	@Column
	private String tipo;
	
	@Column
	private String nombreReceta;
	
	@Column
	private String instrucciones;
	
	@ManyToMany(mappedBy = "books")
	private ArrayList<Ingrediente> ingredientes;
	
	@ManyToOne
    @JoinColumn(name="recetario_id")
    private Recetario recetario;

	@Override
	public int hashCode() {
		return Objects.hash(id, nombreReceta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		return id == other.id && Objects.equals(nombreReceta, other.nombreReceta);
	}
	
	
	
}
