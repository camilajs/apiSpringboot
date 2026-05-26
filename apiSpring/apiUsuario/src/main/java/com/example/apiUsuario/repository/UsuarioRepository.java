package com.example.apiUsuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apiUsuario.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    
}
