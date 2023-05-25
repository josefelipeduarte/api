package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.database.RepositorioContato;
import com.example.demo.entity.Contato;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/contato")
public class ContatoRest {
    @Autowired
    private RepositorioContato repositorio;

    @GetMapping
    public List<Contato> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato) {
        repositorio.save(contato);
    }

    @PutMapping
    public void editar(@RequestBody Contato contato) {
        if (contato.getId() > 0) {
            repositorio.save(contato);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repositorio.deleteById(id);
    }

}
