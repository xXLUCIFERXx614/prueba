package com.PruebasSaberPro.app.Controlador;

import com.PruebasSaberPro.app.Entidades.Estudiante;

import com.PruebasSaberPro.app.Exception.NotFoundException;
import com.PruebasSaberPro.app.Repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;

    // Obtener todos los estudiantes
    @GetMapping
    public String obtenerTodosEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteRepositorio.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes"; // Nombre de la plantilla HTML
    }

    // Mostrar formulario para crear un nuevo estudiante
    @GetMapping("/new")
    public String mostrarFormularioNuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estu-form"; // Nombre de la plantilla HTML para el formulario
    }

    // Crear un nuevo estudiante
    @PostMapping("/save")
    public String crearEstudiante(@Valid Estudiante estudiante, Model model) {
        estudianteRepositorio.save(estudiante);
        return "redirect:/estudiantes"; // Redirigir a la lista de estudiantes después de crear uno nuevo
    }

    // Obtener un estudiante por su ID
    @GetMapping("/{id}")
    public String obtenerEstudiantePorId(@PathVariable(value = "id") String estudianteId, Model model) {
        Estudiante estudiante = estudianteRepositorio.findById(estudianteId)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con el ID: " + estudianteId));
        model.addAttribute("estudiante", estudiante);
        return "estudianteSolo"; // Redirige al perfil del estudiante
    }

    // Mostrar formulario para editar un estudiante
    @GetMapping("/edit/{id}")
    public String mostrarFormularioEditarEstudiante(@PathVariable(value = "id") String estudianteId, Model model) {
        Estudiante estudiante = estudianteRepositorio.findById(estudianteId)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con el ID: " + estudianteId));
        model.addAttribute("estudiante", estudiante);
        return "estu-form"; // Reutiliza la misma plantilla HTML para el formulario
    }

    // Actualizar un estudiante
    @PostMapping("/update/{id}")
    public String actualizarEstudiante(@PathVariable(value = "id") String estudianteId,
                                       @Valid Estudiante detallesEstudiante, Model model) {
        Estudiante estudiante = estudianteRepositorio.findById(estudianteId)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con el ID: " + estudianteId));

        // Actualizar los campos del estudiante con los nuevos detalles
        estudiante.setNombre(detallesEstudiante.getNombre());
        estudiante.setApellido(detallesEstudiante.getApellido());
        // Agrega el resto de los campos aquí

        estudianteRepositorio.save(estudiante);
        return "redirect:/estudiantes";
    }

    // Eliminar un estudiante
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable(value = "id") String estudianteId) {
        Estudiante estudiante = estudianteRepositorio.findById(estudianteId)
                .orElseThrow(() -> new NotFoundException("Estudiante no encontrado con el ID: " + estudianteId));

        estudianteRepositorio.delete(estudiante);
        return "redirect:/estudiantes";
    }
}
