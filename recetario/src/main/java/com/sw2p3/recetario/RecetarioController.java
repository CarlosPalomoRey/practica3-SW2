package com.sw2p3.recetario;

import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RecetarioController {

  private final RecetarioRepository repository;

  RecetarioController(RecetarioRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/recetarios")
  List<Recetario> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/recetarios")
  Recetario newRecetario(@RequestBody Recetario newRecetario) {
    return repository.save(newRecetario);
  }

  // Single item
  
  @GetMapping("/recetarios/{id}")
  EntityModel<Recetario> one(@PathVariable Long id) {

	  Recetario recetario = repository.findById(id) //
        .orElseThrow(() -> new RecetarioNotFoundException(id));

    return EntityModel.of(recetario, //
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecetarioController.class).one(id)).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecetarioController.class).all()).withRel("recetarios"));
  }

  @PutMapping("/recetarios/{id}")
  Recetario replaceRecetario(@RequestBody Recetario newRecetario, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(recetario -> {
        recetario.setName(newRecetario.getName());
        recetario.setRole(newRecetario.getRole());
        return repository.save(recetario);
      })
      .orElseGet(() -> {
        newRecetario.setId(id);
        return repository.save(newRecetario);
      });
  }

  @DeleteMapping("/recetarios/{id}")
  void deleteRecetario(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
