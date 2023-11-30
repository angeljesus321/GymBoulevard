package com.boulevard.fitness.detalleboleta;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boulevard.fitness.entidades.DetalleBoleta;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/detalleboletas")
@AllArgsConstructor
public class DetalleBoletaController {

	IDetalleBoletaRepository detalleBoletaRepository;
	
	 @GetMapping("/listar")
	    public List<DetalleBoleta> obtenerDetalles(){
	        return detalleBoletaRepository.findAll();
	    }
	

}
