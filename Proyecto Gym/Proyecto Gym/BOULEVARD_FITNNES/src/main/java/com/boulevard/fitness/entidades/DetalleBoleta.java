package com.boulevard.fitness.entidades;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "detalle_boleta")
@AllArgsConstructor
@NoArgsConstructor
public class DetalleBoleta {
	
	@Id
	@Column(name = "id_detalle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_detalle;
	@Column(name = "id_boleta")
	private int id_boleta;
	private String descripcion_detalle;
	@Column(name = "cod_producto")
	private String cod_producto;
	
	@ManyToOne
	@JoinColumn(name = "id_boleta", insertable = false, updatable = false)
	@JsonIgnore
	private Boleta boleta;
	
	@ManyToOne
    @JoinColumn(name = "cod_producto", insertable = false, updatable = false)
	@JsonIgnore
    private Producto producto;
	
	 	
}
