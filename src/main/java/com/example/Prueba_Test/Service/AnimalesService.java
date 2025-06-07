package com.example.Prueba_Test.Service;


import com.example.Prueba_Test.Repository.AnimalRepository;
import com.example.Prueba_Test.domain.Animales;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalesService {

    private final AnimalRepository animalRepository;

    public Animales insertaAnimal(Animales animal) {

        return animalRepository.save(animal);
    }

    public Animales encuentraAnimal(String tipo) {
        return animalRepository.findByNombre(tipo).orElseThrow
                (() -> new IllegalArgumentException("Animal no encontrado"));
    }
}
