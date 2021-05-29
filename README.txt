Ejemplos para hacer POST.

/recetarios
{"name": "Recetario 1", "tipo": "Mediterráneo"}
{"name": "Recetario 2", "tipo": "Italiano"}

/recetarios/id/recetas
{"dificultad": "Fácil", "tipo": "Italiano", "nombreReceta":"Macarrones Boloñesa" , "instrucciones": "Instrucciones para los macarrones boloñesa"}
{"dificultad": "Fácil", "tipo": "Americana", "nombreReceta":"Hot Dog" , "instrucciones": "Instrucciones para Hot Dog"}

/recetarios/id/recetas/id/ingrediente
{"nombreIngrediente": "Macarrones", "cantidad": "100 Gramos"}
{"nombreIngrediente": "Salchicha", "cantidad": "2"}