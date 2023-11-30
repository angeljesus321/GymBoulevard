package com.boulevard.fitness.boleta;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boulevard.fitness.entidades.Boleta;

@Repository
public interface IBoletaRepository extends JpaRepository<Boleta, Integer>{

	Optional<Boleta> findFirstByOrderById();
    //List<Boleta> findVentaByFechaBetween(Date fechaInicio, Date fechaFin);
}
