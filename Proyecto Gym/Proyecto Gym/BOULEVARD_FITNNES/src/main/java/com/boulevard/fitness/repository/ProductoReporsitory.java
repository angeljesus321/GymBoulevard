package com.boulevard.fitness.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.boulevard.fitness.entidades.Producto;



public interface ProductoReporsitory extends JpaRepository<Producto, String> {

	
}
