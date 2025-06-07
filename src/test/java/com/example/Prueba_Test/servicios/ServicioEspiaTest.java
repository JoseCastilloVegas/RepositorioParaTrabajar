/*package com.example.Prueba_Test.servicios;

import com.example.Prueba_Test.Repository.Espia;
import com.example.Prueba_Test.Service.ServicioEspia;
import com.example.Prueba_Test.domain.Animales;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ServicioEspiaTest {

    @Spy
    Espia espia;

    @InjectMocks
    ServicioEspia servicioEspia;


    private Animales pato;

    @BeforeEach
    void set() {
        pato = new Animales(1L, "Pato");
    }

    @Test
    void guardaAnimal() {

        Animales animal=servicioEspia.guardaAnimal(pato);

        assertEquals(1L,animal.getId());

        verify(espia,times(1)).save(pato);

    }

    @Test
    void encuentraAnimal() {

        Animales animal=servicioEspia.encuentraAnimalId(pato.getId());

        verify(espia).getById(1L);


    }

   @Test
    void dameAPablito(){

        String s=servicioEspia.nombre();

        assertEquals("Pablito",s);

        verify(espia).damePablito();
   }
}*/