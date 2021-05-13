package com.sw2p3.recetario;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import pojos.Receta;

@Entity
class Recetario {

  private @Id @GeneratedValue Long id;
  
  @Column(nullable=false)
  private String name;
  @Column
  private String tipo;
  
  @OneToMany(mappedBy = "recetario")
  private ArrayList<Receta> recetas;
  
  public Recetario(String name, String tipo) {
    this.name = name;
    this.tipo = tipo;
  }
  
  
  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	Recetario other = (Recetario) obj;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

@Override
  public String toString() {
    return "Recetario{" + "id=" + this.id + ", name='" + this.name + '\'' + ", tipo='" + this.tipo + '\'' + '}';
  }
}
