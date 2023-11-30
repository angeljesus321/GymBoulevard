package com.boulevard.fitness.entidades;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cliente {
	
	 @Id
	 @Column(name = "cod_cli")
	 public String cod_cli;
	 public String nom_cli;
	 public String ape_cli;
	 public String numdoc_cli;
	 public String telf_cli;
	 public String correo_cli;
	 public Date fecha_inicio;
	 public Date fecha_fin;
	

	
	@ManyToOne
    @JoinColumn(name = "tipo_clase")
	public Clase tipo_clase;

    @ManyToOne
    @JoinColumn(name = "tipo_membresia")
    public Membresia tipo_membresia;

    @ManyToOne
    @JoinColumn(name = "tipo_documento")
    public Documento tipo_documento;
	
	
	

}
