package com.PruebasSaberPro.app.Controlador;
import com.PruebasSaberPro.app.Entidades.Estudiante;
import com.PruebasSaberPro.app.Exception.NotFoundException;
import com.PruebasSaberPro.app.Repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestControlador {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    // Endpoint para obtener todos los estudiantes
    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepositorio.findAll();
    }

    // Endpoint para obtener un estudiante por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable String id) {
        Estudiante estudiante = estudianteRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con ID: " + id));
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo estudiante
    @PostMapping
    public ResponseEntity<Estudiante> crearEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteRepositorio.save(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un estudiante existente
    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable String id, @RequestBody Estudiante estudiante) {
        estudiante.setId(id); // Establecer el ID del estudiante a actualizar
        Estudiante estudianteActualizado = estudianteRepositorio.save(estudiante);
        return new ResponseEntity<>(estudianteActualizado, HttpStatus.OK);
    }

    // Endpoint para eliminar un estudiante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable String id) {
        Estudiante estudiante = estudianteRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con ID: " + id));
        estudianteRepositorio.delete(estudiante);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
