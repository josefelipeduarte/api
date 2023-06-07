package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
    Usuario findByEmailAndPassword(String email, String password);
}
