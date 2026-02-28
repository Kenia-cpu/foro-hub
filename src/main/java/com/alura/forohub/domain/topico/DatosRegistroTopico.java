package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotBlank String curso,

        // Aquí integre 3 columnas personalizadas:
        @NotBlank String categoria,
        @NotNull  Integer prioridad,
        @NotBlank String etiquetas
) {
}