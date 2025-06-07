package com.example.Prueba_Test.Repository;

import com.example.Prueba_Test.domain.Animales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnimalRepository extends JpaRepository<Animales,Long> {

    Optional<Animales> findByNombre(String nombre);
}
