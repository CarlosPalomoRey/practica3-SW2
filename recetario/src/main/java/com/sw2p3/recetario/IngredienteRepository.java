package com.sw2p3.recetario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long>{
	 //http://localhost:8080/authors/search
    //http://localhost:8080/authors/search/findByName?name=J.R.R. Tolkien
    Ingrediente findByName(@Param("name") String name);
}
