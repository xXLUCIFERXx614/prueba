package com.PruebasSaberPro.app.Controlador;

import com.PruebasSaberPro.app.Entidades.Coordinador;
import com.PruebasSaberPro.app.Exception.NotFoundException;
import com.PruebasSaberPro.app.Repositorio.CoordinadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class coordinadoresRestControlador {

    @Autowired
    private CoordinadorRepositorio coordinadorRepositorio;

    // Obtener todos los coordinadores
    @GetMapping("/coordinadores")
    public List<Coordinador> obtenerTodosCoordinadores() {
        return coordinadorRepositorio.findAll();
    }

    // Crear un nuevo coordinador
    @PostMapping("/coordinadores")
    public Coordinador crearCoordinador(@Valid @RequestBody Coordinador coordinador) {
        return coordinadorRepositorio.save(coordinador);
    }

    // Obtener un coordinador por su ID
    @GetMapping("/coordinadores/{id}")
    public Coordinador obtenerCoordinadorPorId(@PathVariable(value = "id") Long coordinadorId) {
        return coordinadorRepositorio.findById(coordinadorId)
                .orElseThrow(() -> new NotFoundException("Coordinador no encontrado con el ID: " + coordinadorId));
    }

    // Actualizar un coordinador
    @PutMapping("/coordinadores/{id}")
    public Coordinador actualizarCoordinador(@PathVariable(value = "id") Long coordinadorId,
                                             @Valid @RequestBody Coordinador detallesCoordinador) {
        Coordinador coordinador = coordinadorRepositorio.findById(coordinadorId)
                .orElseThrow(() -> new NotFoundException("Coordinador no encontrado con el ID: " + coordinadorId));

        coordinador.setNombre(detallesCoordinador.getNombre());
        coordinador.setApellido(detallesCoordinador.getApellido());
        coordinador.setTelefono(detallesCoordinador.getTelefono());
        coordinador.setEmail(detallesCoordinador.getEmail());
        coordinador.setContraseña(detallesCoordinador.getContraseña());
        coordinador.setRole(detallesCoordinador.getRole());

        return coordinadorRepositorio.save(coordinador);
    }

    // Eliminar un coordinador
    @DeleteMapping("/coordinadores/{id}")
    public void eliminarCoordinador(@PathVariable(value = "id") Long coordinadorId) {
        Coordinador coordinador = coordinadorRepositorio.findById(coordinadorId)
                .orElseThrow(() -> new NotFoundException("Coordinador no encontrado con el ID: " + coordinadorId));

        coordinadorRepositorio.delete(coordinador);
    }
}
