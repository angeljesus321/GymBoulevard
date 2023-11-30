package com.boulevard.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boulevard.fitness.entidades.Cliente;
import com.boulevard.fitness.entidades.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer> {

}
