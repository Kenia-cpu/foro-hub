package com.alura.forohub.controller;

import com.alura.forohub.domain.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        var duplicado = repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje());

        if (duplicado) {

            System.out.println("Error: El tópico ya existe en la base de datos.");
            throw new RuntimeException("Tópico duplicado: ya existe uno con el mismo título y mensaje.");
        }
        repository.save(new Topico(datos));
        System.out.println("Tópico guardado exitosamente en PostgreSQL");
    }
    @GetMapping
    public Page<DatosListadoTopico> listarTopicos(@PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion) {
        return repository.findAll(paginacion).map(DatosListadoTopico::new);
    }

    @GetMapping("/buscar")
    public Page<DatosListadoTopico> buscarPorCurso(
            @RequestParam String curso,
            @PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion) {
        return repository.findByCurso(curso, paginacion).map(DatosListadoTopico::new);
    }
    @GetMapping("/buscarAvance")
    public Page<DatosListadoTopico> buscarPorCursoYAño(
            @RequestParam String curso,
            @RequestParam int año,
            @PageableDefault(size = 10, sort = {"fechaCreacion"}) Pageable paginacion) {

        return repository.findByCursoAndFechaCreacionYear(curso, año, paginacion)
                .map(DatosListadoTopico::new);
    }
    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DatosListadoTopico(topico));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizar(@PathVariable Long id, @RequestBody @Valid DatosActualizacionTopico datos) {
        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            var topico = optionalTopico.get();
            topico.actualizarDatos(datos);
            return ResponseEntity.ok(new DatosDetalladoTopico(topico));
        }

        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminar(@PathVariable Long id) {
        var optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}