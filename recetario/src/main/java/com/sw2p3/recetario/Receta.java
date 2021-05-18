package com.sw2p3.recetario;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


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
	
	@ManyToMany(mappedBy = "ingredientes")
	private List<Ingrediente> ingredientes;
	
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



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreReceta() {
		return nombreReceta;
	}

	public void setNombreReceta(String nombreReceta) {
		this.nombreReceta = nombreReceta;
	}
	
	public String getInstrucciones() {
		return instrucciones;
	}

	public void setInstrucciones(String instrucciones) {
		this.instrucciones = instrucciones;
	}


	public Recetario getRecetario() {
		return recetario;
	}

	public void setRecetario(Recetario recetario) {
		this.recetario = recetario;
	}

	public void addIngrediente(Ingrediente ingrediente) {
		ingredientes.add(ingrediente);
    }



	@Override
	public String toString() {
		return "Receta:  id=" + id  + ", nombreReceta=" + nombreReceta + "dificultad=" + dificultad + ", tipo=" + tipo;
	}
	
	
	
}
