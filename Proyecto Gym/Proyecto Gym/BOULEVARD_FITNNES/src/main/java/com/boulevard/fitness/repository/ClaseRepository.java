package com.boulevard.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boulevard.fitness.entidades.Clase;
import com.boulevard.fitness.entidades.Cliente;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {

}
