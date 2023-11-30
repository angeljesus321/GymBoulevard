package com.boulevard.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boulevard.fitness.entidades.Cliente;
import com.boulevard.fitness.entidades.Membresia;

public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {

}
