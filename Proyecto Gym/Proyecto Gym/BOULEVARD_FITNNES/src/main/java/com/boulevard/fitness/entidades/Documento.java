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
@Table(name = "documento")
public class Documento {
	 @Id
	 public int cod_documento;
	 public   String des_documento;

	    @OneToMany(mappedBy = "tipo_documento")
	    @JsonIgnore
	    public Set<Cliente> clientes; // Cambiado a plural para reflejar la relación bidireccional
}
