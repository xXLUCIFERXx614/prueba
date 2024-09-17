package com.PruebasSaberPro.app.Controlador;

import com.PruebasSaberPro.app.Entidades.Estudiante;
import com.PruebasSaberPro.app.Repositorio.EstudianteRepositorio;
import com.PruebasSaberPro.app.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class mostrarDatosControlador {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    @GetMapping("/mostrar/{id}")
    public String mostrarDatos(@PathVariable(value = "id") String id, Model model) {
        Estudiante estudiante = estudianteRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con el ID: " + id));

        model.addAttribute("estudiante", estudiante);
        return "mostrar-datos"; 
    }
}
