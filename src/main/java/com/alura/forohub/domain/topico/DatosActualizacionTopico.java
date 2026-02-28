package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull
        Long id,
        String titulo,
        String mensaje,
        String categoria,
        Integer prioridad,
        String etiquetas
) {
}