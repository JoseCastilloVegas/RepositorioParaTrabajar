package com.example.Prueba_Test.servicios;

import com.example.Prueba_Test.Repository.AnimalRepository;
import com.example.Prueba_Test.Service.AnimalesService;
import com.example.Prueba_Test.domain.Animales;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AnimalesServiceTest {

   @Mock
    AnimalRepository animalRepository;

    @InjectMocks
    AnimalesService animalesService;

    @Test
    void insertaAnimal() {

        Animales pato=new Animales(1L,"Pato");

        Animales animal=animalesService.insertaAnimal(pato);

        verify(animalRepository).save(pato);

    }

    @Test
    void encuentraAnimal() {
    }
}