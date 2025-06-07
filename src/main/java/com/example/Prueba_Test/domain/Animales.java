package com.example.Prueba_Test.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Animales {
    @Id
    private Long id;

    @Column(name = "tipo")
    private String nombre;


}
