package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.RepositorioUsuario;
import com.example.demo.entity.Usuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioREST {
    @Autowired
    private RepositorioUsuario repositorio;

    @PostMapping("/register")
    public Usuario Register(@RequestBody Usuario user) {
        return repositorio.save(user);
    }

    @PostMapping("/login")
    public Usuario Login(@RequestBody Usuario user) {
        Usuario oldUSer = repositorio.findByEmailAndPassword(user.getEmail(), user.getPassword());
        return oldUSer;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Usuario usuario) {
        repositorio.save(usuario);
    }

    @PutMapping
    public void alterar(@RequestBody Usuario usuario) {
        if (usuario.getIdUsuario() > 0) {
            repositorio.save(usuario);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repositorio.deleteById(id);
    }
}