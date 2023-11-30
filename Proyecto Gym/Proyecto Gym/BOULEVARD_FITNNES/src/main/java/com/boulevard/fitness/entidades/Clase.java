package com.boulevard.fitness.entidades;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
public class Clase {
	@Id
	public int cod_clase;
	
	public String des_clase;
	@OneToMany(mappedBy = "tipo_clase")
    @JsonIgnore
    public Set<Cliente> cliente;
}
