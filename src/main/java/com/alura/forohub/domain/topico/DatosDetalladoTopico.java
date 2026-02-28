package com.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalladoTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        String autor,
        String curso,
        String categoria,  //  mejora
        Integer prioridad, //  mejora
        String etiquetas   // mejora
) {
    public DatosDetalladoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso(),
                topico.getCategoria(),
                topico.getPrioridad(),
                topico.getEtiquetas()
        );
    }
}