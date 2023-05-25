package com.example.demo.database;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Contato;

public interface RepositorioContato extends JpaRepository<Contato, Long> {

}
