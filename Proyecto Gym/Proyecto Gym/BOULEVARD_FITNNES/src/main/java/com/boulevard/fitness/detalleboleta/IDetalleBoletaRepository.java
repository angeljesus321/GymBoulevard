package com.boulevard.fitness.detalleboleta;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boulevard.fitness.entidades.DetalleBoleta;

public interface IDetalleBoletaRepository extends JpaRepository<DetalleBoleta, Integer>{
	List<DetalleBoleta> findByBoletaId(int id);



	
	
}
