package com.sw2.libraries;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(RecetarioRepository recRepo, RecetaRepository recetaRepo, IngredienteRepository ingRepo) {

        return args -> {
            Recetario rec = new Recetario();
            recRepo.save(rec);
            recetario.setName("Recetario 1");
            recetario.setTipo("asdfg");
            recRepo.save(rec);
            
            Receta receta = new Receta();
            recetaRepo.save(receta);
            receta.setDificultad("Fácil");
            receta.setTipo("Americana");
            receta.setNombre("Hot Dog");
            receta.setInstrucciones("Meter la salchicha en el pan");
            
            receta.setRecetario(rec);
            recetario.addReceta(receta);
            recRepo.save(rec);
            recetaRepo.save(receta);
            
            Ingrediente ing = new Ingrediente();
            ing.setNombreIngrediente("Salchicha");
            ing.setCantidad("2");
            receta.addIngrediente(ing);
            recetaRepo.save(receta);
            ingRepo.save(ing);
            
            Ingrediente ing2 = new Ingrediente();
            ing.setNombreIngrediente("Pan Hot Dog");
            ing.setCantidad("1");
            receta.addIngrediente(ing2);
            recetaRepo.save(receta);
            ingRepo.save(ing2);
          
            
        };
    }
}