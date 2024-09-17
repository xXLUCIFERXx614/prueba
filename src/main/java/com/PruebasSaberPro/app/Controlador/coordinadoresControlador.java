package com.PruebasSaberPro.app.Controlador;

import com.PruebasSaberPro.app.Entidades.Coordinador;
import com.PruebasSaberPro.app.Entidades.Estudiante;
import com.PruebasSaberPro.app.Exception.NotFoundException;
import com.PruebasSaberPro.app.Repositorio.CoordinadorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/coordinadores")
public class coordinadoresControlador {

    @Autowired
    private CoordinadorRepositorio coordinadorRepositorio;

    @GetMapping
    public String obtenerTodosCoordinadores(Model model) {
        List<Coordinador> coordinadores = coordinadorRepositorio.findAll();
        model.addAttribute("coordinadores", coordinadores);
        return "coordinadores";
    }

    @GetMapping("/new")
    public String mostrarFormularioCrearCoordinador(Model model) {
        model.addAttribute("coordinador", new Coordinador()); 
        return "coor-form"; 
    }


    @PostMapping
    public String crearCoordinador(@ModelAttribute("coordinador") Coordinador coordinador) {
        coordinadorRepositorio.save(coordinador);
        return "redirect:/coordinadores";
    }



    @GetMapping("/edit/{id}")
    public String mostrarFormularioEditarCoordinador(@PathVariable("id") Long id, Model model) {
        Coordinador coordinador = coordinadorRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Coordinador no encontrado con el ID: " + id));
        model.addAttribute("coordinador", coordinador);
        return "coor-form"; 
    }

    @PostMapping("/edit/{id}")
    public String actualizarCoordinador(@PathVariable("id") Long id, Coordinador detallesCoordinador) {
        Coordinador coordinador = coordinadorRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Coordinador no encontrado con el ID: " + id));

        coordinador.setNombre(detallesCoordinador.getNombre());
        coordinador.setApellido(detallesCoordinador.getApellido());
        coordinador.setTelefono(detallesCoordinador.getTelefono());
        coordinador.setEmail(detallesCoordinador.getEmail());
        coordinador.setContraseña(detallesCoordinador.getContraseña());
        coordinador.setRole(detallesCoordinador.getRole());

        coordinadorRepositorio.save(coordinador); // Aquí es donde guardas los cambios

        return "redirect:/coordinadores";
    }

    @GetMapping("/delete/{id}")
    public String eliminarCoordinador(@PathVariable("id") Long id) {
        Coordinador coordinador = coordinadorRepositorio.findById(id)
                .orElseThrow(() -> new NotFoundException("Coordinador no encontrado con el ID: " + id));
        coordinadorRepositorio.delete(coordinador);
        return "redirect:/coordinadores";
    }
}
