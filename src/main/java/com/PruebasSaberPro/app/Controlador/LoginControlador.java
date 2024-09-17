package com.PruebasSaberPro.app.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.PruebasSaberPro.app.Entidades.Coordinador;
import com.PruebasSaberPro.app.Entidades.Estudiante;
import com.PruebasSaberPro.app.Repositorio.CoordinadorRepositorio;
import com.PruebasSaberPro.app.Repositorio.EstudianteRepositorio;

@Controller
public class LoginControlador {
	   @Autowired
	    private EstudianteRepositorio estudianteRepository;

	    @Autowired
	    private CoordinadorRepositorio coordinadorRepository;

	    @GetMapping("/login")
	    public String showLoginForm() {
	        return "login";
	    }

	    @PostMapping("/login")
	    public String login(String email, String contraseña, Model model) {
	        Estudiante estudiante = estudianteRepository.findByEmail(email);
	        Coordinador coordinador = coordinadorRepository.findByEmail(email);

	        if (estudiante != null && estudiante.getContraseña().equals(contraseña)) {
	            model.addAttribute("estudiante", estudiante);
	            // Redirigir al panel de estudiante
	            return "estudiantePerfil";
	        } else if (coordinador != null && coordinador.getContraseña().equals(contraseña)) {
	            // Redirigir al panel de coordinador
	            List<Estudiante> estudiantes = estudianteRepository.findAll();
	            model.addAttribute("estudiantes", estudiantes);
	            return "estudiantes";
	        } else {
	            model.addAttribute("error", "Correo o contraseña incorrectos");
	            return "login";
	        }
	    }
}
