package com.sw2p3.recetario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long>{
	 //http://localhost:8080/authors/search
    //http://localhost:8080/authors/search/findByName?name=J.R.R. Tolkien
    Ingrediente findByName(@Param("name") String name);
}
