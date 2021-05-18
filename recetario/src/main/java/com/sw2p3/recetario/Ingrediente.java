package com.sw2p3.recetario;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;


@Entity
class Ingrediente {
	
	@Id
    @GeneratedValue
    private long id;
	
	@Column
	private String nombreIngrediente;
	@Column
	private String cantidad;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ingrediente_receta", 
	    joinColumns = @JoinColumn(name = "receta_id", referencedColumnName = "id"), 
	    inverseJoinColumns = @JoinColumn(name = "ingrediente_id", 
	    referencedColumnName = "id"))
	private List<Receta> recetas;
	
	public Ingrediente() {
		super();
		recetas = new ArrayList<>();
	}
	

	public Ingrediente(String nombreIngrediente, String cantidad) {
		super();
		this.nombreIngrediente = nombreIngrediente;
		this.cantidad = cantidad;
		recetas = new ArrayList<>();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombreIngrediente() {
		return nombreIngrediente;
	}


	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombreIngrediente == null) ? 0 : nombreIngrediente.hashCode());
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
		Ingrediente other = (Ingrediente) obj;
		if (id != other.id)
			return false;
		if (nombreIngrediente == null) {
			if (other.nombreIngrediente != null)
				return false;
		} else if (!nombreIngrediente.equals(other.nombreIngrediente))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nombreIngrediente=" + nombreIngrediente + ", cantidad=" + cantidad
				+ ", recetas=" + recetas + "]";
	}

}
