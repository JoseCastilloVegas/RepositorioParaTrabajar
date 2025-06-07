/*package com.example.Prueba_Test.Service;

import com.example.Prueba_Test.Repository.Espia;
import com.example.Prueba_Test.domain.Animales;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ServicioEspia {

    private final Espia espia;

    public Animales guardaAnimal(Animales animales){

        return espia.save(animales);
    }

    public Animales encuentraAnimal(String nombre){
        return espia.findByNombre(nombre).orElseThrow(()->new IllegalArgumentException("No encontrado"));
    }

    public Animales encuentraAnimalId(Long id){
        return espia.getById(id);
    }

    public String nombre(){
        return espia.damePablito();
    }

}*/
