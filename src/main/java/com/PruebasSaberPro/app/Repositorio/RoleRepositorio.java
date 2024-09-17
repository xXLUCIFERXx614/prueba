package com.PruebasSaberPro.app.Repositorio;

import com.PruebasSaberPro.app.Entidades.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepositorio extends JpaRepository<Role, String> {

    Role findByRole(String role);

}
