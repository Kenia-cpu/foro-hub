package com.alura.forohub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // Mejora 3: ¡El guardia no deja pasar títulos vacíos!
    private String titulo;

    @NotBlank // Mejora 3: El mensaje también debe tener letras
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;

    private String autor;
    private String curso;

    // Mejora 1: El semáforo de importancia (Urgente, Normal, Baja)
    private String prioridad = "NORMAL";

    // Mejora 2: El contador de cuántas personas leyeron el mensaje
    private Integer visualizaciones = 0;

}