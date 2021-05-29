package com.sw2p3.recetario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "recetarios")
interface RecetarioRepository extends CrudRepository<Recetario, Long> {

}
