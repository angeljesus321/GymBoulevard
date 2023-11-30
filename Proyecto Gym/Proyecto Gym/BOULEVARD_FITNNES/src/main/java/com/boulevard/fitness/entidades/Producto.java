package com.boulevard.fitness.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "producto")
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
	@Id
	public String cod_producto;
	public String des_producto;
	public String marca_producto;
	public double pre_producto;
	public int stock_producto;

}
