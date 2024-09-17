package com.PruebasSaberPro.app.Repositorio;

import com.PruebasSaberPro.app.Entidades.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, String> {

    Estudiante findByEmail(String email);

}
