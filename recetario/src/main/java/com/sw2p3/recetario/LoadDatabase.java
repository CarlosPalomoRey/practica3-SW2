package com.sw2p3.recetario;

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
            //recRepo.save(rec);
            rec.setName("Recetario 1");
            rec.setTipo("asdfg");
            recRepo.save(rec);
            
            Receta receta = new Receta();
            recetaRepo.save(receta);
            receta.setDificultad("Facil");
            receta.setTipo("Americana");
            receta.setNombreReceta("Hot Dog");
            receta.setInstrucciones("Meter la salchicha en el pan");
            
            receta.setRecetario(rec);
            rec.addReceta(receta);
            recRepo.save(rec);
            recetaRepo.save(receta);
            
            
            Ingrediente ing = new Ingrediente();
            ing.setNombreIngrediente("Salchicha");
            ing.setCantidad("2");
            ing.addReceta(receta);
            receta.addIngrediente(ing);
            recetaRepo.save(receta);
            ingRepo.save(ing);
            log.info("Preloading " + ingRepo.save(ing));
            
            Ingrediente ing2 = new Ingrediente();
            ing2.setNombreIngrediente("Pan Hot Dog");
            ing2.setCantidad("1");
            ing2.addReceta(receta);
            ingRepo.save(ing2);
            receta.addIngrediente(ing2);
            recetaRepo.save(receta);
            
            
        };
    }
}