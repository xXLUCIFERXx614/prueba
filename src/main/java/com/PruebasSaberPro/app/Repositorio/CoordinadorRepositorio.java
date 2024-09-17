package com.PruebasSaberPro.app.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.PruebasSaberPro.app.Entidades.Coordinador;

public interface CoordinadorRepositorio extends JpaRepository<Coordinador, Long> {
    Coordinador findByEmail(String email);
}

