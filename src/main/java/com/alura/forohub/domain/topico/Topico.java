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

    @NotBlank
    private String titulo;

    @NotBlank
    private String mensaje;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;

    private String autor;
    private String curso;

    // Campos adicionales que añadiste a tu tabla [cite: 2026-02-25]
    private String categoria;
    private String etiquetas;
    private Integer prioridad;

    // Mejora 2: El contador de visualizaciones
    private Integer visualizaciones = 0;


    public Topico(DatosRegistroTopico datos) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.autor = datos.autor();
        this.curso = datos.curso();
        this.categoria = datos.categoria();
        this.prioridad = datos.prioridad();
        this.etiquetas = datos.etiquetas();
        this.fechaCreacion = LocalDateTime.now();
        this.status = StatusTopico.NO_RESPONDIDO;
    }
    public void actualizarDatos(DatosActualizacionTopico datos) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.categoria() != null) {
            this.categoria = datos.categoria();
        }
        if (datos.prioridad() != null) {
            this.prioridad = datos.prioridad();
        }
        if (datos.etiquetas() != null) {
            this.etiquetas = datos.etiquetas();
        }
    }
}