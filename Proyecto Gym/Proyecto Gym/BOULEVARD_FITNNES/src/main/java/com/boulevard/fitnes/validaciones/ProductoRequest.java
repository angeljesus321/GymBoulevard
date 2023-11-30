package com.boulevard.fitnes.validaciones;

import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Setter;

@Setter
@Data
public class ProductoRequest {
	 @Id
	    public String cod_producto;

	    @NotBlank(message = "La descripción del producto no puede estar en blanco")
	    public String des_producto;

	    @NotBlank(message = "La marca del producto no puede estar en blanco")
	    public String marca_producto;

	    @NotNull(message = "El precio del producto no puede estar en blanco")
	    @Digits(integer = 10, fraction = 2, message = "El precio del producto debe ser un número con un máximo de 10 dígitos en la parte entera y 2 en la parte decimal")
	    public Double pre_producto;

	    @NotNull(message = "El stock del producto no puede estar en blanco")
	    @Digits(integer = 100, fraction = 0, message = "El stock del producto debe ser un número entero con un máximo de 100 dígitos")
	    public Integer stock_producto;
}
