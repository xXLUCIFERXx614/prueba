package com.PruebasSaberPro.app.Controlador;

import com.PruebasSaberPro.app.Entidades.Estudiante;
import com.PruebasSaberPro.app.Repositorio.EstudianteRepositorio;
import com.PruebasSaberPro.app.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class mostrarDatosRestControlador {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @GetMapping("/mostrar-rest/{id}")
    public ResponseEntity<Estudiante> mostrarDatos(@PathVariable(value = "id") String id) {
        Estudiante estudiante = estudianteRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con el ID: " + id));

        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }
}
